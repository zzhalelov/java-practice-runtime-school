package kz.practice.collections.map.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    private final static List<User> users = new ArrayList<>();
    private final static Map<Long, User> userMap = new HashMap<>();

    public static void main(String[] args) {
        // создадим 1 миллион пользователей
        for (long i = 1; i <= 1_000_000L; i++) {
            users.add(new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUserInArrayList(378_366L);
        final long endTime = System.nanoTime();

        //создадим хэш-таблицу
        for (long i = 1; i <= 1_000_000L; i++) {
            userMap.put(i, new User(i, "Имя " + i));
        }

        final long startTime1 = System.nanoTime();
        User user1 = findUserInMap(378_366L);
        final long endTime1 = System.nanoTime();

        System.out.println("Найден пользователь: " + user);
        System.out.println("Поиск по ArrayList занял " + (endTime - startTime) + " наносекунд.");
        System.out.println();
        System.out.println("Найден пользователь: " + user1);
        System.out.println("Поиск по HashMap занял " + (endTime1 - startTime1) + " наносекунд.");
    }

    private static User findUserInArrayList(Long userId) {
        for (User user : users) {
            if (user.id.equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private static User findUserInMap(Long userId) {
        return userMap.get(userId);
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}