package greedy;

public class buyStockTWO122 {
    //贪心
    public int maxProfit0(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i-1], 0);
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
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
