package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Задание: Дан список строк List<String>. Разделите строки на группы по их длине.
// Цель: Использовать Collectors.groupingBy.
public class Task_11 {
    public static void main(String[] args) {
        List<String> strings = List.of("Torvalds", "Musk", "Jobs", "Bezos", "Zuckerberg");
        Map<Integer, List<String>> stringMap = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(stringMap);
    }
}