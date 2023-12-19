package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class coins322 {
    //回溯法 超时了
    int minNum = Integer.MAX_VALUE;
    public int coinChange0(int[] coins, int amount) {
        int num = amount;
        List<Integer> coin = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            coin.add(coins[i]);
        }
        backtrack(coin, num, 0, 0);
        if (minNum == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minNum;
        }
    }

    private void backtrack(List<Integer> coins, int num, int sum, int coinNum) {
        if (num == sum) {
            if (coinNum < minNum) {
                minNum = coinNum;
            }
            return;
        }
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i) > num) {
                continue;
            }
            sum = sum + coins.get(i);
            coinNum++;
            if (!(sum > num)) {
                backtrack(coins, num, sum, coinNum);
            }
            coinNum--;
            sum = sum - coins.get(i);
        }
    }


    //自己写的动态规划
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
