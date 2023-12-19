package dynamic_programming;

public class longestContinuous647 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int len = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                len++;
            } else {
                len = 1;
            }
            if (maxLen < len) {
                maxLen = len;
            }
            pre = nums[i];
        }
        return maxLen;
    }
}
