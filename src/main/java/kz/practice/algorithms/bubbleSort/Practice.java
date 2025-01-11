package kz.practice.algorithms.bubbleSort;

import java.util.Arrays;

public class Practice {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 4, 2, 1, 3, 8, 6, 5, 0};
        bubbleSort(array);
    }
}