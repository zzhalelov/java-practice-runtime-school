package kz.practice.functional_style.stream.part_2;

import java.util.Arrays;
import java.util.List;

// Задача 18. Подсчет уникальных символов
// Задание: Дан список строк. Найдите количество уникальных символов во всех строках.
// Цель: Использовать комбинацию flatMap и distinct.
public class Task_18 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        long result = strings.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .count();
        System.out.println(result);
    }
}