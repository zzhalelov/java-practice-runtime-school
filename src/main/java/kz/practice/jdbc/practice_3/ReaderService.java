package kz.practice.jdbc.practice_3;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import static kz.practice.jdbc.practice_3.ConnectionManager.getConnection;

public class ReaderService {
    static Scanner scanner = new Scanner(System.in);

    public static void addReader() {
        try (Connection connection = getConnection()) {
            System.out.println("Введите имя пользователя:");
            String name = scanner.nextLine();

            System.out.println("Введите email пользователя:");
            String email = scanner.nextLine();
            try (PreparedStatement prepared = connection.prepareStatement("INSERT INTO readers (name, email) VALUES (?,?)")) {
                prepared.setString(1, name);
                prepared.setString(2, email);
                prepared.executeUpdate();
                System.out.println("Читатель добавлен");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loanBook() {
        try (Connection connection = getConnection()) {
            System.out.println("Введите id книги:");
            int bookId = scanner.nextInt();
            System.out.println("Введите id читателя:");
            int readerId = scanner.nextInt();
            System.out.println("Введите дату выдачи книги. Год, месяц, день:");
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            LocalDate loanDate = LocalDate.of(year, month, day);

            try (PreparedStatement prepared = connection.prepareStatement("INSERT INTO loans (book_id, reader_id, loan_date) VALUES (?,?,?)")) {
                prepared.setInt(1, bookId);
                prepared.setInt(2, readerId);
                prepared.setDate(3, Date.valueOf(loanDate));
                prepared.executeUpdate();
                System.out.println("Добавлена запись о выдаче книги");
            }
            try (PreparedStatement prepared = connection.prepareStatement("UPDATE books SET available = false WHERE id = ?")) {
                prepared.setInt(1, bookId);
                prepared.executeUpdate();
                System.out.println("Статус доступности книги изменен на false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook() {
        try (Connection connection = getConnection()) {
            System.out.println("Введите id возврашаемой книги:");
            int bookId = scanner.nextInt();

            System.out.println("Введите дату возврата книги. Год, месяц, день:");
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            LocalDate returnDate = LocalDate.of(year, month, day);

            try (PreparedStatement prepared = connection.prepareStatement("UPDATE loans SET return_date = ? WHERE book_id = ? AND return_date IS NULL")) {
                prepared.setDate(1, Date.valueOf(returnDate));
                prepared.setInt(2, bookId);
                prepared.executeUpdate();
                System.out.println("Книги возвращена. Дата возврата: " + returnDate);
            }
            try (PreparedStatement prepared = connection.prepareStatement("UPDATE books SET available = true WHERE id = ?")) {
                prepared.setInt(1, bookId);
                prepared.executeUpdate();
                System.out.println("Статус доступности книги изменен на true");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readerHistory() {
        try (Connection connection = getConnection()) {
            System.out.print("Введите id читателя: ");
            int readerId = scanner.nextInt();

            try (PreparedStatement prepared = connection.prepareStatement("SELECT books.id, books.title, books.author, books.year, loans.loan_date, loans.return_date " +
                    "FROM loans, books " +
                    "INNER JOIN loans l on books.id = l.book_id " +
                    "WHERE l.reader_id = ?;")) {
                prepared.setInt(1, readerId);

                try (ResultSet result = prepared.executeQuery()) {
                    while (result.next()) {
                        System.out.println("Книга ID: " + result.getInt("id"));
                        System.out.println("Название: " + result.getString("title"));
                        System.out.println("Автор: " + result.getString("author"));
                        System.out.println("Год: " + result.getInt("year"));
                        System.out.println("Дата выдачи: " + result.getDate("loan_date"));
                        System.out.println("Дата возврата: " + result.getDate("return_date"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAvailableBooks() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM books WHERE available = true");
            while (result.next()) {
                System.out.println("Книга ID: " + result.getInt("id"));
                System.out.println("Название: " + result.getString("title"));
                System.out.println("Автор: " + result.getString("author"));
                System.out.println("Год: " + result.getInt("year"));
                System.out.println("Дата выдачи: " + result.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showStatistics() {
        try (Connection connection = getConnection()) {
            Statement countBooksStatement = connection.createStatement();
            Statement countOfAvailableBooksStatement = connection.createStatement();
            Statement countOfNonAvailableBooksStatement = connection.createStatement();
            Statement activeReadersStatement = connection.createStatement();

            ResultSet countBooks = countBooksStatement.executeQuery("SELECT COUNT(*) AS count FROM books");
            ResultSet countOfAvailableBooks = countOfAvailableBooksStatement.executeQuery("SELECT COUNT(*) AS availableBooks FROM books WHERE available = true");
            ResultSet countOfNonAvailableBooks = countOfNonAvailableBooksStatement.executeQuery("SELECT COUNT(*) AS nonAvailableBooks FROM books WHERE available = false");
            ResultSet activeReaders = activeReadersStatement.executeQuery("SELECT COUNT(reader_id) AS activeBooks FROM readers INNER JOIN loans l on readers.id = l.reader_id WHERE l.return_date IS NULL");

            if (countBooks.next()) {
                System.out.println("Общее количество книг в библиотеке: " + countBooks.getInt("count"));
            }
            if (countOfAvailableBooks.next()) {
                System.out.println("Общее количество доступных книг в библиотеке: " + countOfAvailableBooks.getInt("availableBooks"));
            }
            if (countOfAvailableBooks.next()) {
                System.out.println("Общее количество выданных книг в библиотеке: " + countOfNonAvailableBooks.getInt("nonAvailableBooks"));
            }
            if (activeReaders.next()) {
                System.out.println("Количество активных читателей: " + activeReaders.getInt("activeBooks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}