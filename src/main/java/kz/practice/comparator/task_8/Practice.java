package kz.practice.comparator.task_8;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 29));
        persons.add(new Person("Adam", 14));
        persons.add(new Person("William", 30));
        persons.add(new Person("Thomas", 11));
        persons.add(new Person("Chris", 15));

        persons.removeIf(n -> n.age() < 18);
        System.out.println(persons);
    }
}