package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Задача 12. Подсчет элементов в группах
// Задание: Дан список строк List<String>. Подсчитайте количество строк в каждой группе, разделив их по длине.
// Цель: Использовать Collectors.groupingBy и Collectors.counting.
public class Task_12 {
    public static void main(String[] args) {
        List<String> strings = List.of("Torvalds", "Musk", "Jobs", "Bezos", "Zuckerberg");
        Map<Integer, Long> listMap = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(listMap);
    }
}