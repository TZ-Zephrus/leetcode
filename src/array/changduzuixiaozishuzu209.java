package array;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//        找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
//        示例 1：
//
//        输入：target = 7, nums = [2,3,1,2,4,3]
//        输出：2
//        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//        示例 2：
//
//        输入：target = 4, nums = [1,4,4]
//        输出：1
//        示例 3：
//
//        输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//        输出：0

public class changduzuixiaozishuzu209 {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }

    //暴力法 超出时间限制！
    public static int minSubArrayLen2(int target, int[] nums) {
        int length = nums.length+1;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum = sum + nums[j];
                if (sum >= target){
                    length = Math.min(length, (j - i + 1));
                    break;
                }
            }
        }
        return length == nums.length+1?0:length;
    }

    //滑动窗口 有两个循环但是时间复杂度为O(n)
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length+1;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target){
                length = length > i-j+1 ? i-j+1 : length;
                sum = sum - nums[j];
                j++;
            }
        }
        return length == nums.length+1?0:length;
    }
}
