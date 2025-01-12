package kz.practice.stack;

import java.util.Stack;

//Задача 5. Сортировка стека
// Задание: Напишите метод, который принимает стек и возвращает его отсортированным (по убыванию).
// Пример: Вход: [3, 1, 4, 2] → Выход: [4, 3, 2, 1]
// Цель: Изучить алгоритмы сортировки для стека.

public class Task_3 {
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        Stack<Integer> sortedStack = sortStack(stack);
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}