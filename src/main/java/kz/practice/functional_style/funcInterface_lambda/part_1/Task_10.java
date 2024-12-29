package kz.practice.functional_style.funcInterface_lambda.part_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

//TODO: Отсортируйте список строк по количеству символов в порядке возрастания, а затем переведите их все в нижний регистр.
public class Task_10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "ALPHA",
                "BETA",
                "GAMMA",
                "DELTA",
                "EPSILON",
                "ZETA",
                "MU",
                "KSI",
                "OMICRON"
        ));
        UnaryOperator<List<String>> unaryOperator = Task_10::changeList;
        unaryOperator.apply(list);
    }

    static List<String> changeList(List<String> list) {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        list.sort(comparator);
        list.replaceAll(String::toLowerCase);
        System.out.println(list);
        return list;
    }
}