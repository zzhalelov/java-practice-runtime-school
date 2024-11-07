package kz.practice.jdbc.practice_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    static {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/runtime_practice";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, user, password);
    }
}