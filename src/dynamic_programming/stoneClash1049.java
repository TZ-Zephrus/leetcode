package dynamic_programming;

import java.util.Arrays;

public class stoneClash1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < stones.length; i++){
            for (int j = sum/2; j >= 0; j--) {
                if (j >= stones[i]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                } else {
                    dp[j] = dp[j];
                }
            }
            for (int i1 : dp) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }

        return sum - dp[target] - dp[target];
    }
}
