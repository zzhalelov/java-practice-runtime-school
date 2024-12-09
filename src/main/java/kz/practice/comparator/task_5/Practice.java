package kz.practice.comparator.task_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        NameComparator comparator = new NameComparator();
        List<String> names = new ArrayList<>(List.of("Анна", "Иван", "Ольга", "Дмитрий", "Екатерина"));
        System.out.println(names);
        //sorting ascending
        names.sort(comparator);
        System.out.println(names);
        //sorting descending
        names.sort(comparator.reversed());
        System.out.println(names);
    }
}