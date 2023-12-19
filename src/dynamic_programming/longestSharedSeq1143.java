package dynamic_programming;

import java.util.Arrays;

public class longestSharedSeq1143 {

    //自己写的超时
    public int longestCommonSubsequence0(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        int maxLen = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1;
                    for (int k = 1; k < i; k++) {
                        for (int l = 1; l < j; l++) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l]+1);
                        }
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxLen;
    }



    //正确答案
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
