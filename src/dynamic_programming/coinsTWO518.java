package dynamic_programming;

import java.util.Arrays;

public class coinsTWO518 {
    public int change(int amount, int[] coins) {
        //初始化为1
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    //先amout后种类
    public int change0(int amount, int[] coins) {
        //初始化为1
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
}
