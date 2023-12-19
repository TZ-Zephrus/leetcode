package dynamic_programming;

import java.util.Arrays;

public class longestIncreasing300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //dp[i]含义为，下标i的元素之前，有dp[i]-1个元素比他小
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
