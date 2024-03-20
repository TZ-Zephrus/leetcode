package hot100.dynamic_programming;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-14
 */
public class PerfectSquare279 {
    public int numSquares(int n) {
        int[] weight = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            weight[i] = i*i;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < weight[i]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
                }
            }
        }
        return dp[n];
    }
}
