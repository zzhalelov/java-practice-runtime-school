package kz.practice.algorithms.task_3;

import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Random random = new Random();

        int target = random.nextInt(1000) + 1;
        System.out.println("Я загадал число. Попробуйте угадать!");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Введите Ваше число: ");
            int myNum = s.nextInt();

            if (myNum < target) {
                System.out.println("Ваше число меньше");
            } else if (myNum > target) {
                System.out.println("Ваше число больше: ");
            } else {
                System.out.println("Правильный ответ");
                break;
            }
        }
    }
}