package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 19. Подсчет чисел в диапазоне
// Задание: Дан список чисел List<Integer>. Подсчитайте, сколько чисел лежат в диапазоне от 10 до 20.
// Цель: Использовать filter и count.
public class Task_19 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30);
        long result = nums.stream()
                .filter(n -> n > 10 && n < 20)
                .count();
        System.out.println(result);
    }
}