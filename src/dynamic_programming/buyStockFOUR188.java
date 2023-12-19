package dynamic_programming;

public class buyStockFOUR188 {
    public int maxProfit(int k, int[] prices) {
        //dp[i][0]是第一次不持有股票  dp[i][1]是第一次持有股票
        //dp[i][2]是第二次不持有股票  dp[i][3]是第二次持有股票
        int[][] dp = new int[prices.length][2*k];
        //初始化
        for (int i = 0; i < 2*k; i++) {
            dp[0][i] = 0;
            i++;
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            for (int j = 2; j < 2*k; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]+prices[i]);
                j++;
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-3]-prices[i]);
            }
        }
        return dp[prices.length-1][2*(k-1)];
    }
}
