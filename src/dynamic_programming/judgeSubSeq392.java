package dynamic_programming;

import java.util.Arrays;

public class judgeSubSeq392 {

    //我这个做的是连续的。。
    public boolean isSubsequence0(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        for (indexT = 0; indexT < t.length(); indexT++) {
            for (int i = 0; i < s.length() && s.charAt(indexS) == t.charAt(indexT+i); i++) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
            indexS = 0;
        }
        return false;
    }


    //双指针
    public boolean isSubsequence1(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        if (s.isEmpty()) {
            return true;
        }
        for (indexT = 0; indexT < t.length(); indexT++) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            if (indexS == s.length()) {
                return true;
            }
        }
        return false;
    }


    //dp
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[s.length()][t.length()]);
        return dp[s.length()][t.length()] == s.length();
    }
}
