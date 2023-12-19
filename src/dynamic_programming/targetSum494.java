package dynamic_programming;

public class targetSum494 {
    //回溯
    int result = 0;
    public int findTargetSumWays0(int[] nums, int target) {
        backtrack(0, target, nums, 0);
        return result;
    }

    public void backtrack(int sum, int target, int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            if (sum == target) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 2; i++ ) {
            if (i==0) {
                sum = sum + nums[startIndex];
                System.out.print("+1 ");
                backtrack(sum, target, nums, startIndex+1);
                sum = sum - nums[startIndex];
            } else if (i==1) {
                sum = sum - nums[startIndex];
                System.out.print("-1 ");
                backtrack(sum, target, nums, startIndex+1);
                sum = sum + nums[startIndex];
            }
        }
    }


    //动态规划
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length-1; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }
}
