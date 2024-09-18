package kz.practice.task_1;

import java.time.LocalDate;
import java.util.*;

public class Practice {
    private final static Set<Letter> letters = new LinkedHashSet<>();

    public static void main(String[] args) {
        letters.add(new Letter("Джон Смит", LocalDate.of(2021, 7, 7), "текст письма №1 ..."));
        letters.add(new Letter("Аманда Линс", LocalDate.of(2021, 6, 17), "текст письма №2 ..."));
        letters.add(new Letter("Джо Кью", LocalDate.of(2021, 7, 5), "текст письма №3 ..."));
        letters.add(new Letter("Мишель Фернандес", LocalDate.of(2021, 8, 23), "текст письма №4 ..."));

        printOrderedById();
        printOrderedByDateReceived();
    }

    private static void printOrderedById() {
        System.out.println("Все письма с сортировкой по ID: ");

        for (Letter letter : Practice.letters) {
            System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dataReceived);
        }
    }

    private static void printOrderedByDateReceived() {
        System.out.println("Все письма с сортировкой по дате получения: ");

        List<Letter> sortedLetters = new ArrayList<>(Practice.letters);

        sortedLetters.sort(new DateComparator());

        for (Letter letter : sortedLetters) {
            System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dataReceived);
        }
    }

    static class Letter {
        public String authorName;
        public LocalDate dataReceived;
        public String text;

        public Letter(String authorName, LocalDate dataReceived, String text) {
            this.authorName = authorName;
            this.dataReceived = dataReceived;
            this.text = text;
        }
    }

    public static class DateComparator implements Comparator<Letter> {
        @Override
        public int compare(Letter letter1, Letter letter2) {
            return letter1.dataReceived.compareTo(letter2.dataReceived);
        }
    }
}