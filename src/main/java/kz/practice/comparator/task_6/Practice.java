package kz.practice.comparator.task_6;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 29));
        personList.add(new Person("Adam", 24));
        personList.add(new Person("William", 30));
        personList.add(new Person("Thomas", 21));
        personList.add(new Person("Chris", 25));

        personList.sort(nameComparator);
        System.out.println(personList);

        personList.sort(ageComparator);
        System.out.println(personList);
    }
}