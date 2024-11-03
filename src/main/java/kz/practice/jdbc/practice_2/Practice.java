package kz.practice.jdbc.practice_2;

import java.sql.*;
import java.util.Scanner;

public class Practice {
    static Scanner scanner = new Scanner(System.in);

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

    public static void main(String[] args) throws Exception {
        Practice.run();
    }

    public static void findAll() throws SQLException {
        try (Connection connection = getConnection()) {
            Statement statement = getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cat");

            while (result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("name: " + result.getString("name"));
                System.out.println("color: " + result.getString("color"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findById() throws SQLException {
        System.out.println("Введите id: ");
        int scannedId = scanner.nextInt();

        try (Connection connection = getConnection();
             PreparedStatement prepared = connection.prepareStatement("SELECT * FROM cat WHERE id = ?")) {
            prepared.setInt(1, scannedId);
            try (ResultSet result = prepared.executeQuery()) {
                while (result.next()) {
                    System.out.println("id: " + result.getInt("id"));
                    System.out.println("name: " + result.getString("name"));
                    System.out.println("color: " + result.getString("color"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertInto() throws SQLException {
        System.out.println("Введите имя: ");
        String scannedName = scanner.nextLine();
        System.out.println("Введите цвет: ");
        String scannedColor = scanner.nextLine();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("INSERT INTO cat (name, color) VALUES (?, ?)");
            prepared.setString(1, scannedName);
            prepared.setString(2, scannedColor);
            prepared.executeUpdate();
            System.out.println("Запись успешно добавлена в БД.");
            System.out.println("name: " + scannedName);
            System.out.println("color: " + scannedColor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete() throws SQLException {
        System.out.println("Введите id: ");
        int scannedId = scanner.nextInt();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("DELETE FROM cat WHERE id = ?");
            prepared.setInt(1, scannedId);
            prepared.executeUpdate();
            System.out.println("Запись из БД с id " + scannedId + " удалена");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() throws SQLException {
        System.out.println("Введите id: ");
        int scannedId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите name: ");
        String scannedName = scanner.nextLine();
        System.out.println("Введите color: ");
        String scannedColor = scanner.nextLine();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("UPDATE cat SET name = ?, color = ? WHERE id = ?");
            prepared.setString(1, scannedName);
            prepared.setString(2, scannedColor);
            prepared.setInt(3, scannedId);
            prepared.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Выберите команду:");
        System.out.println("1 - Найти запись по ID");
        System.out.println("2 - Вывести все записи из БД");
        System.out.println("3 - Добавить запись в БД");
        System.out.println("4 - Удалить запись по ID");
        System.out.println("5 - Обновить запись");
        System.out.println("0 - Выход");
        System.out.println();
    }

    public static void run() throws Exception {
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> findById();
                case "2" -> findAll();
                case "3" -> insertInto();
                case "4" -> delete();
                case "5" -> update();
                case "0" -> {
                    System.out.println("Выход из программы.");
                    return;
                }
            }
        }
    }
}