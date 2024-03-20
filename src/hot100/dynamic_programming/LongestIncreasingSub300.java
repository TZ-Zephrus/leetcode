package hot100.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-18
 */
public class LongestIncreasingSub300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        int maxSub = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSub = Math.max(dp[i], maxSub);
        }
        return maxSub == 0 ? 1 : maxSub;
    }
}
