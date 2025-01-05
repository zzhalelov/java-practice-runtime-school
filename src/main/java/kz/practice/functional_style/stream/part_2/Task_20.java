package kz.practice.functional_style.stream.part_2;

import java.util.Arrays;
import java.util.List;

// Задача 20. Проверка условий
// Задание: Дан список чисел List<Integer>. Проверьте:
// Все ли числа положительные?
// Есть ли хотя бы одно отрицательное число?
// Цель: Использовать методы allMatch, anyMatch, и noneMatch.
public class Task_20 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -4, 5, -6, 7, 8, 9);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Все ли числа положительные? " + allPositive);

        boolean anyNegative = numbers.stream().anyMatch(n -> n < 0);
        System.out.println("Есть ли хотя бы одно отрицательное число? " + anyNegative);

        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Все ли числа неотрицательные? " + noneNegative);
    }
}