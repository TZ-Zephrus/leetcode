package dynamic_programming;

public class buyStock121 {
    //贪心
    public int maxProfit0(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }

    //dp
    public int maxProfit(int[] prices) {
        //dp[i][0]是不持有股票  dp[i][1]是持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
