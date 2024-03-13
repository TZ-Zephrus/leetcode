package hot100.greedy;

import java.sql.Struct;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class JumpGameTWO45 {
    public int jump(int[] nums) {
        int currDis = 0;
        int nextDis = 0;
        int step = 0;
        for (int i = 0; i <= currDis; i++) {
            nextDis = Math.max(nextDis, i + nums[i]);
            if (i == currDis) {
                step++;
                currDis = nextDis;
            }
            if (currDis >= nums.length-1) {
                break;
            }
        }
        return step;
    }
}
