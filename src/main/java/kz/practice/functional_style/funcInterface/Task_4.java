package kz.practice.functional_style.funcInterface;

import java.util.List;
import java.util.function.Consumer;

//TODO: Преобразуйте все слова в списке в верхний регистр.
public class Task_4 {
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

        Consumer<List<String>> capitalizeText = strings -> {
            for (String fruit : fruits) {
                System.out.print(fruit.toUpperCase() + ", ");
            }
        };
        capitalizeText.accept(fruits);
    }
}