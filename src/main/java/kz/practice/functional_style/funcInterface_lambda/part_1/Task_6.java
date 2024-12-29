package kz.practice.functional_style.funcInterface_lambda.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//TODO: Преобразуйте список строк в список их длин.
public class Task_6 {
    public static void main(String[] args) {
        List<String> fruits = List.of(
                "apple",
                "banana",
                "cucumber",
                "eggplant",
                "lemon",
                "melon",
                "potato",
                "raspberry",
                "strawberry",
                "tomato",
                "watermelon"
        );

        UnaryOperator<List<String>> lengthOfString = strings -> {
            List<Integer> length = new ArrayList<>();
            for (String str : fruits) {
                length.add(str.length());
            }
            System.out.println(length);
            return fruits;
        };
        lengthOfString.apply(fruits);
    }
}