package functional_style.funcInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

//TODO: Извлеките объекты из коллекции, чьи названия начинаются с определённой буквы.
public class Task_3 {
    public static void main(String[] args) {
        List<String> names = List.of(
                "Adam",
                "Andrew",
                "Bill",
                "Barbara",
                "Chris",
                "Colin",
                "Edward",
                "John",
                "Jeremy",
                "Justin",
                "Jacob",
                "Kevin",
                "Matthiew",
                "Tom"
        );
        BiFunction<List<String>, String, List<String>> nameStartsWithJ = Task_3::filterByFirstLetter;
        System.out.println(nameStartsWithJ.apply(names, "A"));
    }

    static List<String> filterByFirstLetter(List<String> names, String letter) {
        List<String> newNames = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith(letter)) {
                newNames.add(name);
            }
        }
        return newNames;
    }
}