package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-07
 */
public class Subsets78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }
    public void backtrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
