package kz.practice.functional_style.stream.part_2;

import java.util.List;

//Задача 2. Сумма чисел
//Задание: Дан список чисел List<Integer>. Найдите сумму всех чисел с использованием Stream API.
//Цель: Использовать метод reduce.
public class Task_2 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int sum = nums.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}