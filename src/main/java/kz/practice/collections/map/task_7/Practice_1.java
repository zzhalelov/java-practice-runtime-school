//Отсортируйте телефонную книгу по именам (ключам) и выведите результат.
//Использовать `TreeMap` или преобразование `HashMap` в список для сортировки.
package kz.practice.collections.map.task_7;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Practice_1 {
    public static void main(String[] args) {
        Map<String, String> phoneBookMap = new HashMap<>();
        phoneBookMap.put("Иван", "12345");
        phoneBookMap.put("Мария", "67890");
        phoneBookMap.put("Петр", "54321");

        TreeMap<String, String> treeMap = new TreeMap<>(phoneBookMap);
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}