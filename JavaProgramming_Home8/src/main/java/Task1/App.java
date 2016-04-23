package Task1; /**
 * Created by Abashkin Aleksandr on 07.03.2016.
 */

import java.sql.*;

/**
 * Task 1.
 * 
 * 1. Создать БД в MySQL. Внутри БД создать следующие таблицы:
 *
 * 2. Создайте скрипт создания базы данных.
 *
 * 3. Создайте скрипт заполнения таблиц данными.
 *
 * 4. Создайте консольную программу, которая подключится к базе данных и выведет
 * содержимое таблиц на консоль.
 *
 * 5. Создайте консольную программу которая позволит добавлять данные в DB из CSV
 * файла.
 *
 * Task 2. Создать простое CRUD приложение
 *
 * ­ Использовать паттерн DAO
 */



//Создайте консольную программу, которая подключится к базе данных и выведет содержимое таблиц на консоль.

public class App {
    public static final String URL = "jdbc:mysql://localhost:3306/home8";
    public static final String USER = "root";
    public static final String PASS = "toor";
    public static final String SQL_INSERT = "INSERT INTO student (id, name, surname,enrolment_date,MyGroup_id) VALUES \n" +
            "(NULL, 'Владимир', 'Путин','1980-01-31',1)";
    public static final String SQL_SHOW_ALL = "SELECT * FROM student";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SHOW_ALL);


            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("surname") + " " + rs.getString("enrolment_date") + " " + rs.getInt("MyGroup_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
