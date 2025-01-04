package kz.practice.functional_style.stream.part_2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Задание: Дан текст в виде строки. Разделите его на слова и подсчитайте, сколько раз каждое слово встречается.
// Цель: Использовать комбинацию Stream.of, Collectors.groupingBy, и Collectors.counting.
public class Task_14 {
    public static void main(String[] args) {
        String text = "London is a capital of Great Britain The capital of France is Paris";
        List<String> strings = Arrays.asList(text.split(" "));
        Map<String, Long> listMap = strings.stream()
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        System.out.println(listMap);
    }
}