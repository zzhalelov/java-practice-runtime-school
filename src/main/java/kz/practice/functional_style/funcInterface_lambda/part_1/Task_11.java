package kz.practice.functional_style.funcInterface_lambda.part_1;

import java.util.List;
import java.util.function.Predicate;

//TODO: Напишите анонимную функцию, которая проверяет, есть ли в списке четные числа.
public class Task_11 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 3, 7, 9, 11, 15, 17, 12, 11, 3);

        Predicate<List<Integer>> hasEven = Task_11::existsEven;
        System.out.println(hasEven.test(nums));
    }

    static boolean existsEven(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}