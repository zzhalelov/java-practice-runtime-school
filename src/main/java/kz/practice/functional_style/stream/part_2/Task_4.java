package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.OptionalInt;

// Задача 4. Найти минимальное и максимальное значения
// Задание: Дан список чисел List<Integer>. Найдите минимальное и максимальное значения.
// Цель: Использовать методы min и max.
public class Task_4 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 4, 2, 7, 9, 0, 5, 8, 1);
        OptionalInt min = nums.stream()
                .mapToInt(Integer::intValue)
                .min();
        OptionalInt max = nums.stream()
                .mapToInt(Integer::intValue)
                .max();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}