package kz.practice.jdbc.practice_3;

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

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> addBook();
                case 2 -> getAllBooks();
                case 3 -> findBookByTitle();
                case 4 -> updateBook();
                case 5 -> deleteBook();
                case 0 -> {
                    System.out.println();
                    return;
                }
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/runtime_practice";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, user, password);
    }

    public static void addBook() {
        try (Connection connection = getConnection()) {
            System.out.println("Insert title: ");
            String title = scanner.nextLine();

            System.out.println("Insert author: ");
            String author = scanner.nextLine();

            System.out.println("Insert year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Is book available?");
            boolean available = Boolean.parseBoolean(scanner.nextLine());

            try (PreparedStatement prepared = connection.prepareStatement("INSERT INTO books (title, author, year, available) VALUES (?,?,?,?)")) {
                prepared.setString(1, title);
                prepared.setString(2, author);
                prepared.setInt(3, year);
                prepared.setBoolean(4, available);
                prepared.executeUpdate();
                System.out.println("Книга добавлена успешно.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllBooks() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM books");
            while (result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("title: " + result.getString("title"));
                System.out.println("author: " + result.getString("author"));
                System.out.println("year: " + result.getInt("year"));
                System.out.println("is available: " + result.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findBookByTitle() {
        System.out.println("Insert book's title");
        String title = scanner.nextLine();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
            prepared.setString(1, title);
            try (ResultSet result = prepared.executeQuery()) {
                while (result.next()) {
                    System.out.println("id: " + result.getInt("id"));
                    System.out.println("title: " + result.getString("title"));
                    System.out.println("author: " + result.getString("author"));
                    System.out.println("year: " + result.getInt("year"));
                    System.out.println("is available: " + result.getBoolean("available"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook() {
        System.out.println("Insert source id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Updated title: ");
        String updatedTitle = scanner.nextLine();

        System.out.println("Updated author: ");
        String updatedAuthor = scanner.nextLine();

        System.out.println("Updated year: ");
        int updatedYear = scanner.nextInt();

        System.out.println("Updated availability: ");
        boolean updatedAvailability = scanner.nextBoolean();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("UPDATE books SET title = ?, author = ?, year = ?, available = ? WHERE id = ?");
            prepared.setString(1, updatedTitle);
            prepared.setString(2, updatedAuthor);
            prepared.setInt(3, updatedYear);
            prepared.setBoolean(4, updatedAvailability);
            prepared.setInt(5, id);
            prepared.executeUpdate();
            System.out.println("Данные обновлены!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook() {
        System.out.println("Insert id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            prepared.setInt(1, id);
            prepared.executeUpdate();
            System.out.println("Запись удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Выберите команду:");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Посмотреть все книги");
        System.out.println("3. Найти книгу по названию");
        System.out.println("4. Обновить информацию о книге");
        System.out.println("5. Удалить книгу");
        System.out.println("0. Выход");
    }
}