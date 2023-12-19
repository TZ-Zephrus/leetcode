package hot100.array;

import java.util.Arrays;

public class longestSeq128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int len = 1;
        int maxLen = 1;
        int j = 1;
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                len++;
            } else if (nums[i+1] != nums[i]) {
                len = 1;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
