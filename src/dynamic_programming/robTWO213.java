package dynamic_programming;

public class robTWO213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
         }
        //不考虑尾
        int result1 = robFunction(nums, 0, nums.length-1);
        //不考虑首
        int result2 = robFunction(nums, 1, nums.length);
        return Math.max(result1, result2);
    }

    //索引左闭右开
    private static int robFunction(int[] nums, int startIndex, int endIndex) {
        int[] dp = new int[nums.length];
        dp[startIndex] = nums[startIndex];
        dp[startIndex+1] = Math.max(dp[startIndex], nums[startIndex+1]);
        for (int i = startIndex+2; i < endIndex; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
        }
        return dp[endIndex - 1];
    }
}
