package dynamic_programming;

public class staircaseWithMinCost746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
        }
        return dp[dp.length-1];
    }

    //优化空间复杂度
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;
        int temp = 0;
        for (int i = 2; i <= cost.length; i++) {
            temp = dp[1];
            dp[1] = Math.min(dp[0]+cost[i-2], dp[1]+cost[i-1]);
            dp[0] = temp;
        }
        return dp[1];
    }
}
