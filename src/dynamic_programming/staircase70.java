package dynamic_programming;

public class staircase70 {
    int num = 0;

    public int climbStairs1(int n) {
        recursion(n);
        return num;
    }

    //超时 递归
    public void recursion(int n) {
        if (n == 0) {
            num++;
            return;
        }
        if (n < 0 ){
            return;
        }
        recursion(n-1);
        recursion(n-2);
        return;
    }

    //最基本的dp
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }


}
