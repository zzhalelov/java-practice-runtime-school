package kz.practice.time.birthdayList;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Friend> friendList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1" -> addFriend(friendList);
                case "2" -> daysToBirthday(friendList);
                case "3" -> showFriendList(friendList);
                case "0" -> {
                    System.out.println("Выход из программы");
                    return;
                }
                default -> System.out.println("Ошибка");
            }
        }
    }

    static void printMenu() {
        System.out.println("1. Добавить друга");
        System.out.println("2. Узнать сколько дней осталось до дня рождения друга");
        System.out.println("3. Вывод всех друзей");
        System.out.println("0. Выйти");
        System.out.println("Введите действие: ");

    }

    static void addFriend(List<Friend> friendList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя друга: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату (год месяц день): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        LocalDate dateOfBirth = LocalDate.of(year, Month.of(month), day);
        friendList.add(new Friend(name, dateOfBirth));
        System.out.println("Друг добавлен");
    }

    static void daysToBirthday(List<Friend> friendList) {
        LocalDate now = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        for (Friend friend : friendList) {
            LocalDate birthday = friend.dateOfBirth().withYear(now.getYear());
            int age = now.getYear() - friend.dateOfBirth().getYear();
            if (birthday.isBefore(now)) {
                birthday = birthday.plusYears(1);
                age++;
            }

            long days = ChronoUnit.DAYS.between(now, birthday);
            System.out.println("Дней до дня рождения осталось: " + days);
            System.out.println("Исполнится: " + age);
        }
    }

    static void showFriendList(List<Friend> friendList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Friend friend : friendList) {
            System.out.println(friend.name() + " - " + friend.dateOfBirth().format(formatter));
        }
    }
}

record Friend(String name, LocalDate dateOfBirth) {
}