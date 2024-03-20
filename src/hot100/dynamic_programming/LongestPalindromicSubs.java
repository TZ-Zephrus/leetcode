package hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-19
 */
public class LongestPalindromicSubs {
    public String longestPalindrome(String s) {
        int len = 0;
        String result = "";
        int startIndex = 0;
        int endIndex = 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[i] = dp[i-1] + 1;
                if (dp[i] > len) {
                    len = dp[i];
                    startIndex = i-dp[i-1];
                    endIndex = i;
                }
                continue;
            }
            if (i > dp[i-1] && s.charAt(i) == s.charAt(i-dp[i-1]-1)) {
                dp[i] = dp[i-1] + 2;
                if (dp[i] > len) {
                    len = dp[i];
                    startIndex = i-dp[i-1]-1;
                    endIndex = i+1;
                }
            }
        }
        System.out.println(startIndex);
        return s.substring(startIndex, endIndex);
    }

    public String longestPalindrome2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        char[] array = s.toCharArray();
        int len = 1;
        int startIndex = 0;
        int endIndex = 1;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; j++) {
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    // 当子串长度小于4时，只需要判断两边字符是否相等即可
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1 > len) {
                    len = j-i+1;
                    startIndex = i;
                    endIndex = j+1;
                }
            }
//            System.out.println("----------------");
//            for (int j = 0; j < s.length(); j++) {
//                System.out.println(Arrays.toString(dp[j]));
//            }
//            System.out.println("----------------");

        }
        return s.substring(startIndex, endIndex);
    }
}
