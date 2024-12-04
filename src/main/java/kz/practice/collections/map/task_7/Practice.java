package kz.practice.collections.map.task_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Practice {
    public static void main(String[] args) {
        Map<String, String> phoneBookMap = new HashMap<>();
        phoneBookMap.put("Иван", "12345");
        phoneBookMap.put("Мария", "67890");
        phoneBookMap.put("Петр", "54321");

        for (Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        getValue(phoneBookMap, "Мария");
        remove(phoneBookMap, "Мария");
        System.out.println(phoneBookMap);
        getKey(phoneBookMap, "67890");
    }

    public static void getValue(Map<String, String> map, String name) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println(entry.getValue());
                return;
            } else {
                System.out.println("Контакт не найден");
                return;
            }
        }
    }

    public static void remove(Map<String, String> map, String name) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                map.remove(entry.getKey());
                return;
            }
        }
    }

    public static void getKey(Map<String, String> map, String number) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(number)) {
                System.out.println(entry.getKey());
                return;
            } else {
                System.out.println("Номер не найден");
                return;
            }
        }
    }
}