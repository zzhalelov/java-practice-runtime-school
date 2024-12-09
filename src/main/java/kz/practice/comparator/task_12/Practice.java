package kz.practice.comparator.task_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();

        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person("John", 19));
        personsList.add(new Person("Adam", 24));
        personsList.add(new Person("William", 20));
        personsList.add(new Person("Thomas", 25));
        personsList.add(new Person("Chris", 25));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> {
                    personsList.sort(nameComparator);
                    System.out.println(personsList);
                }
                case "2" -> {
                    personsList.sort(nameComparator.reversed());
                    System.out.println(personsList);
                }
                case "3" -> {
                    personsList.sort(ageComparator);
                    System.out.println(personsList);
                }
                case "4" -> {
                    personsList.sort(ageComparator.reversed());
                    System.out.println(personsList);
                }
                case "0" -> {
                    System.out.println("Выход");
                    return;
                }
            }
        }
    }

    static void printMenu() {
        System.out.println("----------------");
        System.out.println("1 - Сортировать по имени по возрастанию");
        System.out.println("2 - Сортировать по имени по убыванию");
        System.out.println("3 - Сортировать по возрасту по возрастанию");
        System.out.println("4 - Сортировать по возрасту по убыванию");
        System.out.println("0 - Выход");
    }
}