package kz.practice.stack;

import java.util.Stack;

//Задание: Используя стек, напишите метод, который принимает строку и возвращает её в обратном порядке.
//Пример:
//Вход: "hello" → Выход: "olleh"
public class Task_2 {
    public static String reverse(String string) {
        char[] strings = string.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (Character ch : strings) {
            characters.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!characters.isEmpty()) {
            sb.append(characters.pop());
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        reverse("string");
    }
}