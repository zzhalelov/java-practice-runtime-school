package kz.practice.stack;

import java.util.Stack;

//Задание: Напишите метод, который проверяет, правильно ли расставлены скобки в строке.
//Пример:
//Вход: "(a+b)" → true
//Вход: "((a+b))" → true
//Вход: "(a+b]" → false

public class Task_1 {
    public static boolean areBracketsBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else if (character == ')' || character == '}' || character == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((character == ')' && top != '(') ||
                        (character == '}' && top != '{') ||
                        (character == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "(a+b)";
        String expression2 = "((a+b))";
        String expression3 = "(a+b]";

        System.out.println(areBracketsBalanced(expression1));
        System.out.println(areBracketsBalanced(expression2));
        System.out.println(areBracketsBalanced(expression3));
    }
}