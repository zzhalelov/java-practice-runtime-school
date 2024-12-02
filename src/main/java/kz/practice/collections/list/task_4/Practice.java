package kz.practice.collections.list.task_4;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John");
        Student student2 = new Student("Mary");
        Student student3 = new Student("Peter");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println(findStudent("John", students));
    }

    public static boolean findStudent(String name, List<Student> students) {
        for (Student student : students) {
            if (student.name().contains(name)) {
                return true;
            }
        }
        return false;
    }
}