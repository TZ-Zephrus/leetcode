package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-07
 */
public class Arrange46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        recursion(nums, used);
        return result;
    }
    public void recursion(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            recursion(nums, used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
