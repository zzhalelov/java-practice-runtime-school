package kz.practice.functional_style.stream.part_2;

import java.util.List;

// Задача 5. Сортировка чисел
// Задание: Дан список чисел List<Integer>. Отсортируйте его в порядке возрастания и убывания.
// Цель: Использовать метод sorted.
public class Task_5 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 4, 2, 7, 9, 0, 5, 8, 1);
        List<Integer> sortedNums = nums.stream()
                .sorted()
                .toList();
        System.out.println(sortedNums);
    }
}