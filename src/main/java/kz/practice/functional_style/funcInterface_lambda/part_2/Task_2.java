package kz.practice.functional_style.funcInterface_lambda.part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Напишите метод, который принимает список чисел и объект интерфейса Function<Integer, Integer>.
// Метод должен возвращать новый список, где к каждому числу применена переданная функция.
public class Task_2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Function<Integer, Integer> square = s -> (int) Math.pow(s, 2);
        List<Integer> newNumbers = applyFunction(numbers, square);
        System.out.println(newNumbers);
    }

    public static List<Integer> applyFunction(List<Integer> numbers, Function<Integer, Integer> function) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : numbers) {
            result.add(function.apply(integer));
        }
        return result;
    }
}