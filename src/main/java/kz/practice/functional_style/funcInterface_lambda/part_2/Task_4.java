package kz.practice.functional_style.funcInterface_lambda.part_2;

import java.util.List;
import java.util.function.Predicate;

// Напишите метод, который принимает строку и объект интерфейса Predicate<String>.
// Реализуйте проверку, является ли строка палиндромом, с использованием лямбда-выражения.
public class Task_4 {
    public static boolean isPalindrome(String string, Predicate<String> predicate) {
        List<String> stringList = List.of(string.split(""));
        return predicate.test(string);
    }

    public static void main(String[] args) {
        Predicate<String> predicate = string -> {
            String cleanString = string.replaceAll(" ", "").toLowerCase();
            String reversedString = new StringBuilder(cleanString).reverse().toString();
            return cleanString.equals(reversedString);
        };

        String testStr1 = "A man a plan a canal Panama";
        String testStr2 = "Hello World";

        boolean result1 = isPalindrome(testStr1, predicate);
        boolean result2 = isPalindrome(testStr2, predicate);

        System.out.println(testStr1 + " is a palindrome: " + result1);
        System.out.println(testStr2 + " is a palindrome: " + result2);
    }
}