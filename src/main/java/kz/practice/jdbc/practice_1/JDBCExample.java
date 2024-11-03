package kz.practice.jdbc.practice_1;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5433/runtime_practice";
        String user = "postgres";
        String password = "postgres";

        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM sample");
        while (result.next()) {
            System.out.println("id: " + result.getInt(1));
            System.out.println("name: " + result.getString(2));
            System.out.println("value: " + result.getDouble(3));
            System.out.println("isActive: " + result.getBoolean(4));
            System.out.println("insert date: " + result.getDate(5));
            System.out.println("insert time: " + result.getTime(6));
            System.out.println("price: " + result.getDouble(7));
            System.out.println("unknown: " + result.getString(8));
        }
    }
}