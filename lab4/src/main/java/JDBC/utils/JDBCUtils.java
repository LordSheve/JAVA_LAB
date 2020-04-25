package JDBC.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    public static Connection getNewConnection() throws SQLException {

        final String URL = "jdbc:mysql://localhost:3306?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        final String userName = "root";
        final String password = "root";

        Connection connection = DriverManager.getConnection(URL, userName, password);

        if (connection.isValid(1)) {
            System.out.println("Соединение успешно!");
        }

        return connection;
    }

    
}
