package greedy;

public class hopGame55 {
    //递归 超时
    public boolean canJump0(int[] nums) {

        return backtrack(nums, nums.length-1);
    }

    private boolean backtrack(int[] nums, int index) {
        if (index == 0) {
            return true;
        }
        for (int i = index-1; i >= 0 ; i--) {
            if (nums[i] >= index-i) {
                if (backtrack(nums, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int cover = 0;

        for (int i = 0; i <= cover; i++) {
            int currCover = i+nums[i];
            cover = Math.max(cover, currCover);
            if (cover >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
