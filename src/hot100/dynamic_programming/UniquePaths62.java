package hot100.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-19
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
