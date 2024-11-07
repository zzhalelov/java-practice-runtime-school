package kz.practice.jdbc.practice_2;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

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
                case "1" -> CatService.findById();
                case "2" -> CatService.findAll();
                case "3" -> CatService.insertInto();
                case "4" -> CatService.delete();
                case "5" -> CatService.update();
                case "0" -> {
                    System.out.println("Выход из программы.");
                    return;
                }
            }
        }
    }
}