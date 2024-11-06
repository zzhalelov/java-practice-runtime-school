package kz.practice.jdbc.practice_3;

import java.sql.*;
import java.time.LocalDate;
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
                case 6 -> addReader();
                case 7 -> loanBook();
                case 8 -> returnBook();
                case 9 -> readerHistory();
                case 10 -> getAvailableBooks();
                case 0 -> {
                    System.out.println();
                    return;
                }
                default -> System.err.println("Некорректная команда. Попробуйте снова");
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
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM books")) {
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

    public static void printMenu() {
        System.out.println();
        System.out.println("Выберите команду:");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Посмотреть все книги");
        System.out.println("3. Найти книгу по названию");
        System.out.println("4. Обновить информацию о книге");
        System.out.println("5. Удалить книгу");
        System.out.println("6. Создать читателя");
        System.out.println("7. Выдать книгу");
        System.out.println("8. Вернуть книгу");
        System.out.println("9. Просмотр истории выдач читателю");
        System.out.println("10. Просмотр доступных книг");
        System.out.println("0. Выход");
        System.out.println();
    }
}