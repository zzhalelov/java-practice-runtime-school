package kz.practice.functional_style.funcInterface_lambda.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//TODO: Отфильтруйте список чисел, чтобы оставить только чётные значения.
public class Task_1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(101, 102, 103, 104, 105, 106, 107, 108, 109, 110);
        List<Integer> nums2 = List.of(11, 15, 16);

        UnaryOperator<List<Integer>> evenNumbers = list -> {
            List<Integer> newNums = new ArrayList<>();
            for (Integer integer : list) {
                if (integer % 2 == 0) {
                    newNums.add(integer);
                }
            }
            return newNums;
        };
        List<Integer> result = evenNumbers.apply(nums);
        System.out.println(result);
        System.out.println(evenNumbers.apply(nums2));
    }
}