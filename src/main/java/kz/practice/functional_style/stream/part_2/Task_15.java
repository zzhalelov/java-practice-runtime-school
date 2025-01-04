package kz.practice.functional_style.stream.part_2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Задание: Сгенерируйте поток из 10 случайных чисел и выведите их.
// Цель: Использовать метод Stream.generate.
public class Task_15 {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> nums = Stream.generate(random::nextInt)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(nums);
    }
}