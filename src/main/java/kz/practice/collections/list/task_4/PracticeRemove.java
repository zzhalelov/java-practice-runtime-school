package kz.practice.collections.list.task_4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class PracticeRemove {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("jjj");
        strings.add("aaa");
        strings.add("vvv");
        strings.add("aaa");

        LinkedHashSet<String> newStrings = new LinkedHashSet<>(strings);
        System.out.println(newStrings);
    }
}