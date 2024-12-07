package kz.practice.comparator.task_4;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        IntegerComparator comparator = new IntegerComparator();
        ReverseIntegerComparator reverseIntegerComparator = new ReverseIntegerComparator();

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(34);
        integers.add(12);
        integers.add(56);
        integers.add(78);
        integers.add(23);
        integers.add(89);

        //nums before sorting
        System.out.println(integers);
        //nums after sorting
        integers.sort(comparator);
        System.out.println(integers);
        //reverse sorting
        integers.sort(reverseIntegerComparator);
        System.out.println(integers);
    }
}