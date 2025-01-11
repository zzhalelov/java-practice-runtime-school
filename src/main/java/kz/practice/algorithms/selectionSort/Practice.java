package kz.practice.algorithms.selectionSort;

import java.util.Arrays;

public class Practice {
    private static void selectionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[least]) {
                    least = j;
                }
            }
            int buffer = inputArray[i];
            inputArray[i] = inputArray[least];
            inputArray[least] = buffer;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void main(String[] args) {
        int[] inputArray = {9, 7, 4, 2, 1, 3, 8, 6, 5, 0};
        selectionSort(inputArray);
    }
}