package kz.practice.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Map<String, Integer> gradesMap = new HashMap<>();
        gradesMap.put("Иван", 85);
        gradesMap.put("Мария", 90);
        gradesMap.put("Петр", 85);

        for (Map.Entry<String, Integer> entry : gradesMap.entrySet()) {

        }
    }
}