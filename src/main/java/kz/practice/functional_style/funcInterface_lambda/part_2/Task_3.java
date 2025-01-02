package kz.practice.functional_style.funcInterface_lambda.part_2;

import java.util.List;
import java.util.function.BinaryOperator;

// Напишите метод, который принимает список строк и объект интерфейса BinaryOperator<String>.
// Метод должен возвращать одну строку, полученную объединением всех строк из списка,
// используя заданный BinaryOperator.
public class Task_3 {
    public static String combineStrings(List<String> strings, BinaryOperator<String> operator) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        String result = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            result = operator.apply(result, strings.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("alpha", "beta", "gamma", "delta");
        BinaryOperator<String> operator = (s1, s2) -> s1 + "" + s2;
        String combineString = combineStrings(strings, operator);
        System.out.println(combineString);
    }
}