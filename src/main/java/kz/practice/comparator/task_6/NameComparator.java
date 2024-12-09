package kz.practice.comparator.task_6;

public class NameComparator implements java.util.Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name().compareTo(o2.name());
    }
}