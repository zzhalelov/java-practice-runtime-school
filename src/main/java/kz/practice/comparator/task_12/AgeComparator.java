package kz.practice.comparator.task_12;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age() - o2.age();
    }

    @Override
    public Comparator<Person> reversed() {
        return Comparator.super.reversed();
    }
}