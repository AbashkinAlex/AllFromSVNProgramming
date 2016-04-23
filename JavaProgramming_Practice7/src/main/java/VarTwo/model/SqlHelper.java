package VarTwo.model;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Администратор on 09.03.2016.
 */
public class SqlHelper {
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;
    private static final String SQL_DROP = "DROP TABLE IF EXISTS my_user ";
    private static final String SQL_CREATE = "CREATE TABLE `my_user` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `login` varchar(32) NOT NULL," +
            "  `password` varchar(32) NOT NULL," +
            "  `first_name` varchar(32) NOT NULL," +
            "  `last_name` varchar(32) NOT NULL," +
            "  `age` int(11) NOT NULL," +
            "  `role_id` int(11) NOT NULL," +
            "  PRIMARY KEY (`id`,`role_id`)," +
            "  UNIQUE KEY `login_UNIQUE` (`login`)," +
            "  KEY `fk_user_role_idx` (`role_id`)," +
            "  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";

    public static DataSource ds = null;
    private static final String PATH = "mysql.properties";
    static{
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(new File(PATH))){
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = prop.getProperty("url");
        USER = prop.getProperty("db_user");
        PASSWORD = prop.getProperty("db_password");

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(URL);
        mysqlDataSource.setUser(USER);
        mysqlDataSource.setPassword(PASSWORD);
        ds = mysqlDataSource;
    }




    public static void init() throws SQLException {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            st.execute(SQL_DROP);
            st.execute(SQL_CREATE);
        }
    }
}
