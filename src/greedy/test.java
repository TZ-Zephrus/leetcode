package greedy;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-26
 */
public class test {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 3, 4}; // 您给出的数组
        int k = 2; // 分成k段
        System.out.println(maxXorSum(array, k));
    }

    public static int maxXorSum(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k][n];
        int[] xor = new int[n];

        // 计算前缀异或和
        xor[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            xor[i] = xor[i - 1] ^ nums[i];
        }

        // 初始化dp数组，k=1的情况
        for (int i = 0; i < n; ++i) {
            dp[0][i] = xor[i];
        }

        // 计算k>1的情况
        for (int i = 1; i < k; ++i) {
            for (int j = i; j < n; ++j) { // j从i开始，保证至少有i+1个数字
                for (int p = i - 1; p < j; ++p) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][p] + (xor[j] ^ xor[p]));
                }
            }
        }

        return dp[k - 1][n - 1];
    }
}
