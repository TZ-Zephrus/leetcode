package hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-18
 */
public class MaxMultiSubarray152 {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        int result = Integer.MIN_VALUE;
        System.arraycopy(nums, 0, dpmax, 0, nums.length);
        System.arraycopy(nums, 0, dpmin, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dpmax[i] = Math.max(dpmax[i], Math.max(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i]));
                dpmin[i] = Math.min(dpmin[i], Math.min(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i]));
            }
            result = Math.max(result, Math.max(dpmax[i], dpmin[i]));
        }
        return result;
    }
}
