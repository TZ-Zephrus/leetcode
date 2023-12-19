package dynamic_programming;

import java.util.Arrays;

public class perfectSquare279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= Math.sqrt(n); i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
