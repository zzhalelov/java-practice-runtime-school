package kz.practice.functional_style.stream.part_2;

import java.util.Comparator;
import java.util.List;

// Задача 13. Поиск строки с максимальной длиной
// Задание: Дан список строк List<String>. Найдите строку с максимальной длиной.
// Цель: Использовать max с компаратором.
public class Task_13 {
    public static void main(String[] args) {
        List<String> strings = List.of("Torvalds", "Musk", "Jobs", "Bezos", "Zuckerberg");
        String maxString = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(maxString);
    }
}