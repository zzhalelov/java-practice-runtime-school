package kz.practice.files.task_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while_loop:
        while (true) {
            printMenu();

            //чтение команды с консоли
            String command = scanner.nextLine();

            //ввод пользователем пути к файлу/директории
            System.out.println("Введите путь к файлу/директории: ");
            String enteredPath = scanner.nextLine();

            // Объявите переменную path с типом Path.
            Path path = Paths.get(enteredPath);

            // Выполните действия в зависимости от введённой команды.
            switch (command) {
                case "exit":
                    System.out.println("Выход.");
                    break while_loop;
                case "ls":
                    try {
                        // выведите список элементов директории
                        Files.list(path);

                        for (File file : Objects.requireNonNull(path.toFile().listFiles())) {
                            System.out.println(file.getName());
                        }
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при запросе содержимого директории.");
                        e.printStackTrace();
                    }
                    break;
                case "mkdir":
                    try {
                        // создайте директорию
                        System.out.println("Введите имя для директории: ");
                        String newPath = scanner.nextLine();

                        Path directoryPath = Paths.get(enteredPath, newPath);
                        Files.createDirectories(directoryPath);
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании директории.");
                        e.printStackTrace();
                    }
                    break;
                case "touch":
                    try {
                        // создайте файл
                        System.out.println("Введите имя для файла");
                        String newFilePath = scanner.nextLine();

                        Files.createFile(Paths.get(enteredPath, newFilePath));
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании файла.");
                        e.printStackTrace();
                    }
                    break;
                case "rename":
                    System.out.println("Введите новое имя файла/директории: ");
                    String newName = scanner.nextLine();
                    Path newPath = path.getParent().resolve(newName);
                    try {
                        // переименуйте файл
                        System.out.println("Переименовываем " + path + " в " + newPath);
                        Files.move(path, newPath);
                        System.out.println("Файл успешно переименован.");
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при переименовании файла/директории.");
                        e.printStackTrace();
                    }
                    break;
                case "rm_file":
                    try {
                        if (!Files.isDirectory(path)) {
                            // удалите файл
                            Files.deleteIfExists(path);
                        } else {
                            System.out.println("С помощью этой команды можно удалить только файл!");
                        }
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при удалении файла.");
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Что вы хотите сделать? ");
        System.out.println("ls - посмотреть содержимое директории.");
        System.out.println("mkdir - создать директорию.");
        System.out.println("touch - создать файл.");
        System.out.println("rename - переименовать директорию/файл.");
        System.out.println("rm_file - удалить файл.");
        System.out.println("exit - выход.");
        System.out.println();
    }
}