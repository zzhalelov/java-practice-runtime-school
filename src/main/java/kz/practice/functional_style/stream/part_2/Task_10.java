package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.stream.Collectors;

// Задача 10. Конкатенация строк
// Задание: Дан список строк List<String>. Объедините все строки в одну, разделив их запятой.
// Цель: Использовать метод collect с Collectors.joining.
public class Task_10 {
    public static void main(String[] args) {
        List<String> strings = List.of("Torvalds", "Musk", "Jobs", "Bezos", "Zuckerberg");
        String string = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println(string);
    }
}