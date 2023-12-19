package dynamic_programming;

import java.util.Arrays;

public class splitSubset416 {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition0(arr));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum/2;
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[target+1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < nums.length; i++){
            for (int j = sum/2; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                } else {
                    dp[j] = dp[j];
                }
            }
            for (int i1 : dp) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }

        return dp[target] == target;
    }


    public static boolean canPartition0(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            for (int i1 : dp) {
                System.out.print(i1+" ");
            }
            System.out.println();
            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
//            if(dp[target] == target)
//                return true;

        }
        return dp[target] == target;
    }
}
