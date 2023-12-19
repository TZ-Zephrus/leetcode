package backtrack;

import java.util.ArrayList;
import java.util.List;

public class coins322 {
    int minNum = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
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
}
