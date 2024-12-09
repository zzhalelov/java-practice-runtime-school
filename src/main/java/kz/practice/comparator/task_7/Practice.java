package kz.practice.comparator.task_7;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.removeIf(n -> n % 2 == 1);
        System.out.println(list);
    }
}