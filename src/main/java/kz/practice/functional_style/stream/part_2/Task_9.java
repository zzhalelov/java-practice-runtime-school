package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Задача 9. Преобразование в другую коллекцию
// Задание: Дан список строк List<String>. Преобразуйте его в множество (Set).
// Цель: Использовать метод collect с Collectors.toSet().
public class Task_9 {
    public static void main(String[] args) {
        List<String> strings = List.of("Musk", "Torvalds", "Jobs", "Zuckerberg", "Bezos", "Torvalds", "Torvalds");
        Set<String> stringSet = strings.stream()
                .collect(Collectors.toSet());
        System.out.println(stringSet);
    }
}