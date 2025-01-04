package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 3. Преобразование в строки
// Задание: Дан список чисел List<Integer>. Преобразуйте его в список строк, где каждое число представлено в виде строки.
// Цель: Освоить метод map.
public class Task_3 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        List<String> strings = nums.stream()
                .map(String::valueOf)
                .toList();
        System.out.println(strings);
    }
}