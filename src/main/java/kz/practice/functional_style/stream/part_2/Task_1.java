package kz.practice.functional_style.stream.part_2;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.List;

//Задача 1. Выбор четных чисел
//Задание: Дан список чисел List<Integer>. Используя Stream API, выберите только четные числа и выведите их.
//Цель: Освоить методы filter и forEach.
public class Task_1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> filteredNums = nums.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        filteredNums.forEach(System.out::println);
    }
}