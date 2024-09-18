package functional_style.funcInterface;

import java.util.List;
import java.util.function.Function;

//TODO: Напишите анонимную функцию, которая принимает список целых чисел и возвращает сумму всех четных чисел.
public class Task_12 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<List<Integer>, Integer> sum = Task_12::sumEven;
        System.out.println(sum.apply(nums));
    }

    static Integer sumEven(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}