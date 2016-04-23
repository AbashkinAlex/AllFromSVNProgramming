package Task1;

import java.sql.*;
import java.io.*;


/**
 * Created by Abashkin Aleksandr on 07.03.2016.
 */

//Создайте консольную программу которая позволит добавлять данные в DB из CSV
public class ReadFromFile {
    public static final String URL = "jdbc:mysql://localhost:3306/home8";
    public static final String USER = "root";
    public static final String PASS = "toor";
    private final static String CSV_FILE = "src\\main\\resources\\Book.csv";
    private final static String QUERY = "";

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] value = line.split(";"); //разделитель
                String sql = "INSERT INTO student (id, name, surname,enrolment_date,MyGroup_id) VALUES" +
                        "('" + value[0] + "','" + value[1] + "','" + value[2] + "','" + value[3] + "','" + value[4] + "')";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

