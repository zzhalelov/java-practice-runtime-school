package kz.practice.comparator.task_5;

import java.util.Comparator;

public class NameComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }
}