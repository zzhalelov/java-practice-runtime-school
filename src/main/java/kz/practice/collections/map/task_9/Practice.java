//Напишите программу, которая подсчитывает, сколько раз каждое слово встречается в списке строк.
//Использовать HashMap, где ключ — слово, а значение — количество его появлений.
package kz.practice.collections.map.task_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> fruitMap = new HashMap<>();

        for (String element : fruits) {
            if (!fruitMap.containsKey(element)) {
                fruitMap.put(element, 1);
            } else {
                int newCount = fruitMap.get(element) + 1;
                fruitMap.put(element, newCount);
            }
        }

        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}