package kz.practice.functional_style.stream.task_2;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityExample {
    public static void main(String[] args) {
        //множество студентов, успешно сдавших экзамен
        Set<String> examPassedNames = new HashSet<>();
        examPassedNames.add("Иванов Иван");
        examPassedNames.add("Садыков Алибек");

        //соответствие года поступления и названия группы
        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2020, "2020-ГР1");
        groupNames.put(2021, "2021-ГР0");

        //список с адресами email выпускников
        List<String> graduatesClub = new ArrayList<>();

        //студенты, планирующие завершить обучение
        List<Student> students = new ArrayList<>();
        students.add(new Student("Садыков", "Алибек", "asadykov@gmail.com", 2021));
        students.add(new Student("Иванов", "Иван", "ivan_ivanov@gmail.com", 2020));
        students.add(new Student("Аманов", "Куаныш", "iamkuanysh@gmail.com", 2021));

        List<Student> graduatedStudents = students.stream()
                .filter(student -> examPassedNames.contains(student.getName())/* проверка, что студент успешно сдал экзамен */)
                .map(student -> {
                    student.setGroupName(groupNames.get(student.getEntranceYear()));/* заполнение названия группы студента */
                    return student;
                })
                // операция peek выполняет над элементом действие и передаёт далее тот же элемент
                .peek(student -> graduatesClub.add(student.getEmail())/* добавление студента в клуб выпускников */)
                .collect(Collectors.toList());

        for (Student student : graduatedStudents) {
            System.out.println(student);
        }

        for (String email : graduatesClub) {
            System.out.println(email);
        }
    }
}