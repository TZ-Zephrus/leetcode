package dynamic_programming;

public class buyStockTHREE123 {
    public int maxProfit(int[] prices) {
        //dp[i][0]是第一次不持有股票  dp[i][1]是第一次持有股票
        //dp[i][2]是第二次不持有股票  dp[i][3]是第二次持有股票
        int[][] dp = new int[prices.length][2*2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];    //相当于第一次在当天买入、卖出，之后第二次再买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][3]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][2];
    }
}
