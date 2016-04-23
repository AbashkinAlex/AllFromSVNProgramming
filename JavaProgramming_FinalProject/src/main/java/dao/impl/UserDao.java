package dao.impl;


/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */

import dao.Dao;
import model.User;
import model.MusicType;
import model.Role;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.SqlHelper.*;

public class UserDao implements Dao<User> {

    private static final String FOREIGN_KEY_CHECKS0 = "SET FOREIGN_KEY_CHECKS=0";
    private static final String FOREIGN_KEY_CHECKS1 = "SET FOREIGN_KEY_CHECKS=1";
    private static final String SQL_INSERT = "INSERT INTO user (login, mypassword,firstname ,lastname ,age,role_id) VALUES (?,?,?,?,?,?)";
    private static final String SQL_INSERT_USER_MUSIC = "INSERT INTO user_musictype (user_id, music_type_id) VALUES (?,?)";
    private static final String SQL_SELECT_USER_MUSIC = "SELECT music_type_id FROM user_musictype WHERE user_id = ?";
    private static final String SQL_SELECT_MUSIC_TYPE = "SELECT type_name FROM music_type WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  user";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  user WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE user SET login = ?, mypassword = ?, firstname = ?, lastname = ?, age = ?, role_id = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM user WHERE id = ?";

    Context ctx = null;
    DataSource ds = null;
    {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User create(User user) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(FOREIGN_KEY_CHECKS0);
            ps2.executeUpdate();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setInt(5, user.getAge());
            ps.setInt(6, user.getRole().getId());
            System.out.println(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) user.setId(rs.getInt(1));
            Role role = new Role();
            role.addUser(user);
            PreparedStatement ps3 = conn.prepareStatement(FOREIGN_KEY_CHECKS1);
            ps3.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("mypassword"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }



    @Override
    public User getById(int id) {
        User user = null;
        MusicType musicType;
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt1 = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt1.setInt(1, id);
            ResultSet rs = pt1.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("mypassword"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getInt("age"));
                Dao<Role> roleDao = new RoleDao();
                user.setRole(roleDao.getById(rs.getInt("role_id")));
            }
            PreparedStatement pt2 = conn.prepareStatement(SQL_SELECT_USER_MUSIC);
            pt2.setInt(1, id);
            ResultSet rs2 = pt2.executeQuery();
            while (rs2.next()) {
                musicType = new MusicType();
                musicType.setId(rs2.getInt("music_type_id"));
                PreparedStatement pt3 = conn.prepareStatement(SQL_SELECT_MUSIC_TYPE);
                pt3.setInt(1, musicType.getId());
                ResultSet rs3 = pt3.executeQuery();
                while (rs3.next()) {
                    musicType.setTypeName(rs3.getString(1));
                }
                user.addMusicType(musicType);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean update(User user) {
        boolean boo = false;
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, user.getLogin());
            pt.setString(2, user.getPassword());
            pt.setString(3, user.getFirstName());
            pt.setString(4, user.getLastName());
            pt.setInt(5, user.getAge());
            pt.setInt(6, user.getRole().getId());
            pt.setInt(7, user.getId());
            pt.executeUpdate();
            try (Connection conn2 = ds.getConnection()) {
                PreparedStatement StatementUserMusic = conn2.prepareStatement(SQL_INSERT_USER_MUSIC);
                if (user.getMusicTypes().size() != 0) {
                    for (MusicType musicType : user.getMusicTypes()) {
                        StatementUserMusic.setInt(1, user.getId());
                        StatementUserMusic.setInt(2, musicType.getId());
                        boo = StatementUserMusic.executeUpdate() > 0;
                    }
                }
            }
            return (pt.executeUpdate() == 1 || boo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, user.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
