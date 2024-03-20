package hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-18
 */
public class PartitionEqualSubset416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        // int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum/2;
        int[] dp = new int[half+1];
        for (int i = 0; i < dp.length; i++) {
            if (i >= nums[0]) {
                dp[i] = nums[0];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
            if (dp[half] == half) {
                return true;
            }
        }
        return dp[half] == half;
    }
}
