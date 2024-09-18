package files.java_accounting_report;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReportBoard reportBoard = new ReportBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            print();
            String command = scanner.nextLine();

            switch (command) {
                case "1" -> reportBoard.loadMonthlyReports();
                case "2" -> reportBoard.loadYearlyReport();
                case "3" -> reportBoard.checkReports();
                case "4" -> reportBoard.printMonthlyReports();
                case "5" -> reportBoard.printYearlyReport();
                case "0" -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void print() {
        System.out.println();
        System.out.println("Выберите команду:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
        System.out.println();
    }
}