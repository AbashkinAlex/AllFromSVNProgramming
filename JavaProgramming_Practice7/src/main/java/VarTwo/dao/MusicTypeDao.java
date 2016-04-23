package VarTwo.dao;

import VarTwo.model.MusicType;
import VarTwo.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static VarTwo.model.SqlHelper.*;

/**
 * Created by Alexandr Abashkin on 3/22/2016.
 */
public class MusicTypeDao implements Dao<MusicType> {

    private static final String SQL_INSERT = "INSERT INTO music_type(type_name) VALUES (?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  music_type";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  music_type WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE music_type SET type_name = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM music_type WHERE id = ?";


    @Override
    public MusicType create(MusicType musicType) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, musicType.getTypeName());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) musicType.setId(rs.getInt(1));
            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicType;
    }

    @Override
    public List<MusicType> getAll() {
        List<MusicType> musicType = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            MusicType myMusicType = null;
            while (rs.next()) {
                myMusicType = new MusicType();
                myMusicType.setId(rs.getInt("id"));
                myMusicType.setTypeName(rs.getString("type_name"));
                musicType.add(myMusicType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicType;
    }

    @Override
    public MusicType getById(int id) {
        MusicType musicType = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                musicType = new MusicType();
                musicType.setId(rs.getInt("id"));
                musicType.setTypeName(rs.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicType;
    }

    @Override
    public boolean update(MusicType musicType) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, musicType.getTypeName());
            pt.setInt(2, musicType.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(MusicType musicType) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, musicType.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
