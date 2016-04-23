package VarOne.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static VarOne.model.SqlHelper.*;
import VarOne.model.Human;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class HumanDao implements Dao<Human> {

    private static final String SQL_INSERT = "INSERT INTO human(name, age) VALUES (?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  human";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  human WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE students SET name = ?, age = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM students WHERE id = ?";

    @Override
    public Human create(Human human) {

        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, human.getName());
            ps.setInt(2, human.getAge());
            System.out.println(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) human.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return human;
    }

    @Override
    public List<Human> getAll() {
        List<Human> studentsList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            Human human = null;
            while (rs.next()) {
                human = new Human();
                human.setId(rs.getInt("id"));
                human.setName(rs.getString("name"));
                human.setAge(rs.getInt("age"));
                studentsList.add(human);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    @Override
    public Human getById(int id) {
        Human std = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                std = new Human();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }

    @Override
    public boolean update(Human human) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, human.getName());
            pt.setInt(2, human.getAge());
            pt.setInt(3, human.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Human human) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, human.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
