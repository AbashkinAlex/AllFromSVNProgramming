package dao.impl;

import dao.Dao;
import model.Adress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.SqlHelper.*;

/**
 * Created by Abashkin Aleksandr on 23.03.2016.
 */
public class AdressDao implements Dao<Adress> {

    private static final String SQL_INSERT = "INSERT INTO address (id, country, street, zip)  VALUES (?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM  address";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM  address WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE address SET country = ?, street = ?, zip = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM address WHERE id = ?";


    @Override
    public Adress create(Adress adress) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,adress.getId());
            ps.setString(2, adress.getCountry());
            ps.setString(3, adress.getStreet());
            ps.setInt(4, adress.getZipCode());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) adress.setId(rs.getInt(1));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }

    @Override
    public List<Adress> getAll() {
        List<Adress> adress = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            Adress myAdress;
            while (rs.next()) {
                myAdress = new Adress();
                myAdress.setId(rs.getInt("id"));
                myAdress.setCountry(rs.getString("country"));
                myAdress.setStreet(rs.getString("street"));
                myAdress.setZipCode(rs.getInt("zip"));
                adress.add(myAdress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }

    @Override
    public Adress getById(int id) {
        Adress adress = null;
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                adress = new Adress();
                adress.setId(rs.getInt("id"));
                adress.setCountry(rs.getString("country"));
                adress.setStreet(rs.getString("street"));
                adress.setZipCode(rs.getInt("zip"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }



    @Override
    public boolean update(Adress adress) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            pt.setString(1, adress.getCountry());
            pt.setString(2, adress.getStreet());
            pt.setInt(3, adress.getZipCode());
            pt.setInt(4, adress.getUser().getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Adress adress) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement pt = conn.prepareStatement(SQL_DELETE_BY_ID);
            pt.setInt(1, adress.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
