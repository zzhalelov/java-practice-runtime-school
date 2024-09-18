package kz.practice.functional_style.funcInterface;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

//TODO: Верните наибольшее значение из списка строк (по длине).
public class Task_9 {
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
                "tomato"
        );
        Function<List<String>, Integer> findMaxLengthString = Task_9::maxStringLength;
        System.out.println(findMaxLengthString.apply(fruits));
    }

    static Integer maxStringLength(List<String> fruits) {
        Comparator<String> fruitsComparator = Comparator.comparingInt(String::length);

        String longestString = null;
        for (String fruit : fruits) {
            if (longestString == null || fruitsComparator.compare(longestString, fruit) < 0) {
                longestString = fruit;
            }
        }
        return longestString.length();
    }
}