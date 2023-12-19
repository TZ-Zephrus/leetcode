package dynamic_programming;

public class uncrossedLine1035 {

    //记忆化递归dfs
    public int maxUncrossedLines0(int[] nums1, int[] nums2) {
        Integer[][] mem = new Integer[nums1.length][nums2.length];
        int rec = recursion(nums1, nums2, 0, 0, mem);
        return rec;

    }

    public int recursion(int[] nums1, int[] nums2, int index1, int index2, Integer[][] mem) {
        if (index1 >= nums1.length || index2 >= nums2.length) {
            return 0;
        }
        if (mem[index1][index2] != null) {
            return mem[index1][index2];
        }
        int result = 0;
        for (int i = index2; i < nums2.length; i++) {
            //index1选择连上
            if (nums1[index1] == nums2[i]) {
                result = Math.max(result, recursion(nums1, nums2, index1+1, i+1, mem));
            }
        }
        //index2选择没连上
        result = Math.max(result, recursion(nums1, nums2, index1+1, index2, mem));
        //记忆化
        mem[index1][index2] = result;
        return result;
    }


    //dp
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
