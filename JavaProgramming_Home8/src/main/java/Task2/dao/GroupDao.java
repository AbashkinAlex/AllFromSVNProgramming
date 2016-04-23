package Task2.dao;

import Task2.model.MyGroup;
import Task2.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Task2.model.SqlHelper.*;

/**
 * Created by Администратор on 10.03.2016.
 */
public class GroupDao implements Dao<MyGroup> {

    private static final String SQL_INSERT = "INSERT INTO mygroup(number, department) VALUES (?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  mygroup";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  mygroup WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE mygroup SET department = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID_STUDENT = "DELETE FROM student WHERE MyGroup_id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM mygroup WHERE id = ?";


    @Override
    public MyGroup create(MyGroup myGroup) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, myGroup.getNumber());
            ps.setString(2, myGroup.getDepartment());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) myGroup.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myGroup;
    }

    @Override
    public List<MyGroup> getAll() {
        List<MyGroup> myGroupList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            MyGroup myGroup = null;
            while (rs.next()) {
                myGroup = new MyGroup();
                myGroup.setId(rs.getInt("id"));
                myGroup.setNumber(rs.getInt("number"));
                myGroup.setDepartment(rs.getString("department"));
                myGroupList.add(myGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myGroupList;
    }

    @Override
    public MyGroup getById(int id) {
        MyGroup myGroup = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                myGroup = new MyGroup();
                myGroup.setId(rs.getInt("id"));
                myGroup.setNumber(rs.getInt("number"));
                myGroup.setDepartment(rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myGroup;
    }

    @Override
    public boolean update(MyGroup myGroup) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, myGroup.getDepartment());
            pt.setInt(2, myGroup.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(MyGroup myGroup) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt1 = conn.prepareStatement(SQL_DELETE_BY_ID_STUDENT);
            PreparedStatement pt2 = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt1.setInt(1, myGroup.getId());
            pt2.setInt(1, myGroup.getId());
            pt1.executeUpdate();
            return pt2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
