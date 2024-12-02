package kz.practice.collections.map.task_6;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    public static void main(String[] args) {
        HashMap<String, Integer> sales1 = new HashMap<>();
        sales1.put("Товар A", 10);
        sales1.put("Товар B", 5);
        sales1.put("Товар C", 8);

        HashMap<String, Integer> sales2 = new HashMap<>();
        sales2.put("Товар B", 3);
        sales2.put("Товар D", 7);
        sales2.put("Товар E", 2);

        //создаем новую мапу
        HashMap<String, Integer> mergedMap = merge(sales1, sales2);

        //вывод на печать
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static HashMap<String, Integer> merge(HashMap<String, Integer> sales1, HashMap<String, Integer> sales2) {
        //добавляем в новую мапу товары из sales1
        HashMap<String, Integer> mergedMap = new HashMap<>(sales1);

        //перебираем 2ую мапу
        for (Map.Entry<String, Integer> entry : sales2.entrySet()) {
            String product = entry.getKey();
            Integer quantity = entry.getValue();

            //если в 1ой мапе уже содержится товар, прибавляется только кол-во
            //если товара нет в 1ой мапе - добавляется и товар, и кол-во
            if (mergedMap.containsKey(product)) {
                mergedMap.put(product, mergedMap.get(product) + quantity);
            } else {
                mergedMap.put(product, quantity);
            }
        }
        return mergedMap;
    }
}