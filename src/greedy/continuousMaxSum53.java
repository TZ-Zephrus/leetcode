package greedy;

public class continuousMaxSum53 {
    //贪心
    public int maxSubArray0(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum = currSum + num;
            if (result < currSum) {
                result = currSum;
            }
            if (currSum <= 0) {
                currSum = 0;
            }
        }
        return result;
    }

    //dp
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //dp[i]要从两个状态得到：前面的加自身，只有自身
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
