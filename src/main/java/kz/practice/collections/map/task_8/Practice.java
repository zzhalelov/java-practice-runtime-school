package kz.practice.collections.map.task_8;

import kz.practice.jdbc.practice_2.Menu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Иван", 85);
        grades.put("Мария", 90);
        grades.put("Петр", 85);

        Set<Integer> newGrades = new HashSet<Integer>(grades.values());
        int count = 0;
        for (Integer element : newGrades) {
            count += element.intValue();
        }
        System.out.println(count);
    }
}