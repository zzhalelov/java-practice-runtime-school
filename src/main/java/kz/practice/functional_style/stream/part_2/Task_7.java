package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 7. Уникальные элементы
// Задание: Дан список чисел List<Integer>. Выведите только уникальные элементы списка.
// Цель: Использовать метод distinct.
public class Task_7 {
    public static void main(String[] args) {
        List<String> strings = List.of("Musk", "Torvalds", "Jobs", "Zuckerberg", "Bezos", "Torvalds", "Torvalds");
        List<String> newStrings = strings.stream()
                .distinct()
                .toList();
        System.out.println(newStrings);
    }
}