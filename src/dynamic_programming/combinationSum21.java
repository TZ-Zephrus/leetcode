package dynamic_programming;

import java.util.Arrays;

public class combinationSum21 {
    public int combinationSum4(int[] coins, int amount) {
        //初始化为1
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
}
