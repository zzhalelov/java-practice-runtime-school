package kz.practice.comparator.task_9;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        NameComparator nameComparator = new NameComparator();
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 29));
        list.add(new Person("Adam", 24));
        list.add(new Person("William", 30));
        list.add(new Person("Thomas", 25));
        list.add(new Person("Chris", 25));

        list.sort(ageComparator.thenComparing(nameComparator));
        System.out.println(list);
    }
}