package algorithms.task_1;

public class Practice {
    public static int findBinary(int[] array, int elem) {
        String result = isSorted(array);

        int low = 0;
        int high = array.length - 1;

        if (result.equals("asc")) {
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                if (array[mid] < elem) {
                    low = mid + 1;
                } else if (array[mid] > elem) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        } else if (result.equals("desc")) {
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                if (array[mid] > elem) {
                    low = mid + 1;
                } else if (array[mid] < elem) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        } else {
            System.out.println("Ощибка! Бинарный поиск возможен только в упорядоченном массиве");
        }
        return -1;
    }

    public static String isSorted(int[] array) {
        int countDesc = 0;
        int countAsc = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                countDesc++;
            }
            if (array[i] > array[i - 1]) {
                countAsc++;
            }
        }

        if (countAsc == array.length - 1) {
            return "asc";
        } else if (countDesc == array.length - 1) {
            return "desc";
        } else {
            return "unordered";
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findBinary(array, 4));
    }
}