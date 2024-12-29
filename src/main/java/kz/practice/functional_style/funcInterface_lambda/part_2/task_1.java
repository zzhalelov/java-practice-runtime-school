package kz.practice.functional_style.funcInterface_lambda.part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Напишите метод, который принимает список чисел и объект интерфейса Predicate<Integer>.
// Метод должен возвращать новый список, содержащий только те числа,
// которые удовлетворяют условию, заданному в Predicate.
public class task_1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Predicate<Integer> isEven = s -> s % 2 == 0;
        List<Integer> filteredNumbers = filterNumbers(numbers, isEven);
        System.out.println(filteredNumbers);
    }

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                result.add(number);
            }
        }
        return result;
    }
}