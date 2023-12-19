package dynamic_programming;

public class oneAndZero474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int p = 0; p < strs.length; p++) {
            int zeroNum = 0;
            int oneNum = 0;
            //统计元素的0和1出现次数
            for (int k = 0; k < strs[p].length(); k++) {
                if (strs[p].charAt(k) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    //这里，类比0-1背包，zeroNum和oneNum就是重量，1就是价值
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}
