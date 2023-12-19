package dynamic_programming;

import java.util.Scanner;

public class kamarstaricase57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j>=i) {
                    dp[j] += dp[j - i];
                }
            }
        }
    }
}
