package kz.practice.collections.list.task_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeNumbers {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(42, 16, 8, 23));
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }
}