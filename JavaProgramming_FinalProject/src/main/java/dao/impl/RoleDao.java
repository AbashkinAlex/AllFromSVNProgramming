package dao.impl;

import dao.Dao;
import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.SqlHelper.*;

/**
 * Created by Alexandr Abashkin on 3/22/2016.
 */
public class RoleDao implements Dao<Role> {

    private static final String SQL_INSERT = "INSERT INTO role(role_name) VALUES (?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  role";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  role WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE role SET role_name = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM role WHERE id = ?";


    @Override
    public Role create(Role role) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, role.getRoleName());
            System.out.println(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) role.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            Role role = null;
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));
                roleList.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Role getById(int id) {
        Role role = null;
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public boolean update(Role role) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, role.getRoleName());
            pt.setInt(2, role.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Role role) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, role.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
