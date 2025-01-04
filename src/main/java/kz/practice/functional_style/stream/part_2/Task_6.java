package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 6. Подсчет строк определенной длины
// Задание: Дан список строк List<String>. Подсчитайте, сколько строк имеют длину больше 5.
// Цель: Использовать методы filter и count.
public class Task_6 {
    public static void main(String[] args) {
        List<String> strings = List.of("Musk", "Torvalds", "Jobs", "Zuckerberg", "Bezos");
        long count = strings.stream()
                .filter(s -> s.length() > 5)
                .count();
        System.out.println(count);
    }
}