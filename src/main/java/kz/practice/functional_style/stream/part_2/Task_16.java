package kz.practice.functional_style.stream.part_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Задача 16. Сортировка списка объектов
// Задание: Дан список объектов Person с полями name и age. Отсортируйте его:
// По возрасту.
// По имени в алфавитном порядке.
// Цель: Использовать sorted с компаратором.
public class Task_16 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Adam", 18));
        persons.add(new Person("Bill", 30));
        persons.add(new Person("David", 28));
        persons.add(new Person("Matt", 24));
        persons.add(new Person("Tom", 35));

        List<Person> newList = persons.stream()
                .sorted(Comparator.comparingInt(Person::age)
                        .thenComparing(Person::name))
                .toList();
        System.out.println(newList);
    }
}

record Person(String name, int age) {

}