package VarOne.model;
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
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class SqlHelper {
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;
    private static final String SQL_DROP = "DROP TABLE IF EXISTS human";
    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS human(" + "id int AUTO_INCREMENT primary key, "
            + "name varchar(256), age int)";

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