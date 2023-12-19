package dynamic_programming;

import java.util.Scanner;

public class kamarCompletePackage52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int i = completePackge(n, v, weight, value);
        System.out.println(i);
    }

    private static int completePackge(int n, int v, int[] weight, int[] value) {
        int[] dp = new int[v+1];
        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        return dp[v];
    }
}
