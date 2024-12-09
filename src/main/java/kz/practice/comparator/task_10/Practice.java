package kz.practice.comparator.task_10;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        LengthComparator lengthComparator = new LengthComparator();
        List<String> strings = new ArrayList<>();
        strings.add("alpha");
        strings.add("beta");
        strings.add("gamma");
        strings.add("delta");
        strings.add("epsilon");
        strings.add("omikron");
        strings.add("zeta");
        strings.add("omega");

        strings.sort(lengthComparator);
        System.out.println(strings);
    }
}