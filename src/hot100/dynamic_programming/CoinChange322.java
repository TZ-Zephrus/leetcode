package hot100.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-14
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 若无法装满的话，dp会是默认值MAX_VALUE
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
