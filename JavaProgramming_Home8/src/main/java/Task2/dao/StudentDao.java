package Task2.dao;

import static Task2.model.SqlHelper.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Task2.model.Student;

import static Task2.model.SqlHelper.*;

/**
 * Created by Администратор on 09.03.2016.
 */
public class StudentDao implements Dao<Student> {
    private static final String SQL_INSERT = "INSERT INTO student(name, surname, enrolment_date,MyGroup_id) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  student";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  student WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE student SET name = ?, surname = ?, enrolment_date = ?, MyGroup_id = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM student WHERE id = ?";

    @Override
    public Student create(Student student) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getEnrolment_date());
            ps.setInt(4, student.getMyGroup_id());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) student.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentsList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            Student student = null;
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setEnrolment_date(rs.getString("enrolment_date"));
                student.setMyGroup_id(rs.getInt("myGroup_id"));
                studentsList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }


    @Override
    public Student getById(int id) {
        Student student = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setEnrolment_date(rs.getString("enrolment_date"));
                student.setMyGroup_id(rs.getInt("myGroup_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, student.getName());
            pt.setString(2, student.getSurname());
            pt.setString(3, student.getEnrolment_date());
            pt.setInt(4, student.getMyGroup_id());
            pt.setInt(5, student.getId());
           return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, student.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
