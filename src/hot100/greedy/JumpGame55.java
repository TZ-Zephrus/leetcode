package hot100.greedy;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int range = nums[0];
        for (int i = 0; i <= range; i++) {
            range = Math.max(range, i + nums[i]);
            if (range >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
