package functional_style.funcInterface;

import java.util.List;
import java.util.function.Function;

//TODO: Найдите произведение всех чисел в списке.
public class Task_7 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<List<Integer>, Integer> multiplyNums = multiply -> {
            int result = 1;
            for (Integer i : nums) {
                result *= i;
            }
            System.out.println(result);
            return result;
        };
        multiplyNums.apply(nums);
    }
}