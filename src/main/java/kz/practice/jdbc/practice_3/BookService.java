package kz.practice.jdbc.practice_3;

import java.sql.*;
import java.util.Scanner;

import static kz.practice.jdbc.practice_3.ConnectionManager.getConnection;

public class BookService {
    static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        try (Connection connection = getConnection()) {
            System.out.println("Введите название: ");
            String title = scanner.nextLine();

            System.out.println("Автор: ");
            String author = scanner.nextLine();

            System.out.println("Год выпуска: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Доступна ли книга?");
            boolean available = Boolean.parseBoolean(scanner.nextLine());

            try (PreparedStatement prepared = connection.
                    prepareStatement("INSERT INTO books (title, author, year, available) VALUES (?,?,?,?)")) {
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
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM books")) {
            while (result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("Название: " + result.getString("title"));
                System.out.println("Автор: " + result.getString("author"));
                System.out.println("Год: " + result.getInt("year"));
                System.out.println("Доступность: " + result.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findBookByTitle() {
        System.out.println("Введите название книги: ");
        String title = scanner.nextLine();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
            prepared.setString(1, title);
            try (ResultSet result = prepared.executeQuery()) {
                while (result.next()) {
                    System.out.println("id: " + result.getInt("id"));
                    System.out.println("Название: " + result.getString("title"));
                    System.out.println("Автор: " + result.getString("author"));
                    System.out.println("Год: " + result.getInt("year"));
                    System.out.println("Доступность: " + result.getBoolean("available"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook() {
        System.out.println("Введите id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Новое имя: ");
        String updatedTitle = scanner.nextLine();

        System.out.println("Новый автор: ");
        String updatedAuthor = scanner.nextLine();

        System.out.println("Новый год выпуска: ");
        int updatedYear = scanner.nextInt();

        System.out.println("Обновление сведений о доступности: ");
        boolean updatedAvailability = scanner.nextBoolean();

        try (Connection connection = getConnection()) {
            PreparedStatement prepared = connection.
                    prepareStatement("UPDATE books SET title = ?, author = ?, year = ?, available = ? WHERE id = ?");
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
        System.out.println("Введи id:");
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
}