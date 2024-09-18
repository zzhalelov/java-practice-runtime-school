package kz.practice.functional_style.funcInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//TODO: Выберите слова из списка, длина которых превышает 7 символов.
public class Task_2 {
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
        UnaryOperator<List<String>> filteredList = Task_2::filterByLength;
        System.out.println(filteredList.apply(fruits));
    }

    static List<String> filterByLength(List<String> fruits) {
        List<String> filteredStrings = new ArrayList<>();
        for (String fruit : fruits) {
            if (fruit.length() > 7) {
                filteredStrings.add(fruit);
            }
        }
        return filteredStrings;
    }
}