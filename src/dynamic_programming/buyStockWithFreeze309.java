package dynamic_programming;

public class buyStockWithFreeze309 {
    //自己的方法
    public int maxProfit0(int[] prices) {
        //dp[i][0]是不持有股票  dp[i][1]是持有股票
        if (prices.length < 2) {
            return 0;
        }
        //这里把0、1天的单独挑出来，避免后面循环中索引异常
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0]-prices[1]);    //这里的dp[1][1]和后面的1不一样。这里的1天买入，可能因为昨天没买。
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    //随想录
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];  //四个状态
        //dp[i][0]表示当天卖出   dp[i][1]表示当天冻结期   dp[i][2]表示保持未持有   dp[i][3]表示持有股票
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i-1][3] + prices[1];
            dp[i][1] = dp[i-1][0];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
            dp[i][3] = Math.max(dp[i-1][3], Math.max(dp[i-1][1]-prices[i], dp[i-1][2]-prices[i]));
        }
        return Math.max(dp[prices.length-1][0], Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }
}
