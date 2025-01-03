package kz.practice.functional_style.funcInterface_lambda.part_2;

import java.util.ArrayList;
import java.util.List;

// Напишите метод, который сортирует список строк по длине с использованием Comparator, переданного как лямбда-выражение.
public class Task_5 {
    public static void sortByLength(List<String> strings) {
        strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("strawberry", "banana", "cherry", "orange", "apple"));
        System.out.println("До сортировки: " + strings);
        sortByLength(strings);
        System.out.println("После сортировки: " + strings);
    }
}