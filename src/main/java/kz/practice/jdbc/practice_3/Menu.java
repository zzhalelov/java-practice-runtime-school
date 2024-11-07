package kz.practice.jdbc.practice_3;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> BookService.addBook();
                case 2 -> BookService.getAllBooks();
                case 3 -> BookService.findBookByTitle();
                case 4 -> BookService.updateBook();
                case 5 -> BookService.deleteBook();
                case 6 -> ReaderService.addReader();
                case 7 -> ReaderService.loanBook();
                case 8 -> ReaderService.returnBook();
                case 9 -> ReaderService.readerHistory();
                case 10 -> ReaderService.getAvailableBooks();
                case 11 -> ReaderService.showStatistics();
                case 0 -> {
                    System.out.println();
                    return;
                }
                default -> System.err.println("Некорректная команда. Попробуйте снова");
            }
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
        System.out.println("11. Статистика библиотеки");
        System.out.println("0. Выход");
        System.out.println();
    }
}