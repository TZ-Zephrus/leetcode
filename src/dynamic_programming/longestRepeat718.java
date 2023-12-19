package dynamic_programming;

import java.util.Arrays;

public class longestRepeat718 {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]含义为：nums1中以i-1为下标的元素为结尾的字符串和nums2中以j-1为下标的元素为结尾的字符串最长的公共子数组长度
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int maxLen = 0;
//        Arrays.fill(dp[0], 0);
//        for (int i = 0; i < nums2.length+1; i++) {
//            dp[0][i] = 0;
//        }
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j]-1) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }
}
