package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 8. Пропуск и ограничение элементов
// Задание: Дан список чисел List<Integer>. Выведите первые 5 элементов, пропустив первые 2.
// Цель: Использовать методы limit и skip.
public class Task_8 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> newNums = nums.stream()
                .limit(5)
                .skip(2)
                .toList();
        System.out.println(newNums);
    }
}