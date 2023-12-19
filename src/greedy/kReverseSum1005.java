package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class kReverseSum1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] array = Arrays.stream(nums).boxed().sorted((Integer o1, Integer o2) ->
                Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < array.length; i++) {
            if (k <= 0) break;
            if (array[i] < 0) {
                array[i] = -array[i];
                k--;
            }
        }
        int j;
        if ((j = k % 2) > 0) {
            array[array.length-1] = -array[array.length-1];
        }
        return Arrays.stream(array).sum();
    }


    public int largestSumAfterKNegations0(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }
}
