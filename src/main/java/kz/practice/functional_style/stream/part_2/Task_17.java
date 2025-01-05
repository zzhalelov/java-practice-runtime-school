package kz.practice.functional_style.stream.part_2;

import java.util.ArrayList;
import java.util.List;

// Задача 17. Поиск студентов с высоким баллом
// Задание: Дан список объектов Student с полями name и grade. Найдите студентов с баллом выше 80 и выведите их имена.
// Цель: Комбинировать методы filter и map.
public class Task_17 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alfred", 80));
        students.add(new Student("Bob", 55));
        students.add(new Student("Chris", 70));
        students.add(new Student("George", 100));
        students.add(new Student("Hugh", 95));

        List<String> newList = students.stream()
                .filter(s -> s.grade() > 80)
                .map(Student::name)
                .toList();
        System.out.println(newList);
    }
}

record Student(String name, int grade) {

}