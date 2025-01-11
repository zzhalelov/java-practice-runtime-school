package kz.practice.algorithms.insertionSort;

import java.util.Arrays;

public class Practice {
    private static void insertionSort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int x = inputArray[i];
            int j = i;
            while (j > 0 && inputArray[j - 1] > x) {
                inputArray[j] = inputArray[j - 1];
                --j;
            }
            inputArray[j] = x;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void main(String[] args) {
        int[] inputArray = {9, 7, 4, 2, 1, 3, 8, 6, 5, 0};
        insertionSort(inputArray);
    }
}