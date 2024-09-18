package kz.practice.functional_style.funcInterface;

import java.util.List;
import java.util.function.Predicate;

//TODO: Определите, содержит ли список хотя бы одно отрицательное число.
public class Task_8 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, -5, 6, 7, 8, 9, 10);

        Predicate<List<Integer>> isNegative = integer -> {
            for (Integer i : nums) {
                if (i < 0) {
                    return true;
                }
            }
            return false;
        };
        System.out.println(isNegative.test(nums));
    }
}