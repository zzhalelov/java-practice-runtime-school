package kz.practice.map.task_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    // Пример списка пассажиров (на самом деле их больше)
    private static final List<String> passengerNames = List.of(
            "Аймурат Бериков",
            "Диана Азатова",
            "Азамат Бексултанов",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        // Тут нужно написать код, который будет распределять места в самолёте ✈️
        Map<String, Integer> passengers = new HashMap<>();
        for (int i = 0; i < passengerNames.size(); i++) {
            passengers.put(passengerNames.get(i), i + 1);
        }
        return passengers;
    }
}