package kz.practice.functional_style.funcInterface_lambda.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//TODO: Создайте новый список, содержащий квадраты чисел из исходного списка.
public class Task_5 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        UnaryOperator<List<Integer>> newNums = Task_5::calculate;
        System.out.println(newNums.apply(nums));
    }

    static List<Integer> calculate(List<Integer> nums) {
        List<Integer> newNums = new ArrayList<>();
        for (Integer i : nums) {
            newNums.add((int) Math.pow(i, 2));
        }
        return newNums;
    }
}