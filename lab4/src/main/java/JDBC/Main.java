package JDBC;

import JDBC.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = JDBCUtils.getNewConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
