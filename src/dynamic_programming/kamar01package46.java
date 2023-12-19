package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class kamar01package46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int category = sc.nextInt();
        int space = sc.nextInt();
        int[] value = new int[category];
        int[] weight = new int[category];
        for (int i = 0; i < category; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < category; i++) {
            value[i] = sc.nextInt();
        }
        int result = maxValue(category, space, weight, value);
        System.out.println(result);
    }

    private static int maxValue(int category, int space, int[] weight, int[] value) {
        int[][] dp = new int[category][space+1];
        for (int i = 0; i < category; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int j = 0; j < space+1; j++ ) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }
        for (int i = 1; i < category; i++) {
            for (int j = 0; j < space+1; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[category-1][space];
    }
}
