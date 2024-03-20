package hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-14
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = dp[i-1][0] + nums[i];
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
        }
        return Math.max(dp[nums.length-1][1], dp[nums.length-1][0]);
    }
}
