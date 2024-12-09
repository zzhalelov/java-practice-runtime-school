package kz.practice.comparator.task_13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 3.90));
        students.add(new Student("Adam", 5.00));
        students.add(new Student("Tom", 2.70));
        students.add(new Student("Paul", 4.50));
        students.add(new Student("Chris", 2.90));

        students.sort(
                Comparator.comparingDouble(Student::getGrade).reversed()
                        .thenComparing(Student::getName)
        );

        for (Student student : students) {
            System.out.println(student);
        }
    }
}