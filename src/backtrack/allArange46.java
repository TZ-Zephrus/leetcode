package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allArange46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        Arrays.fill(used, 0);
        backtrack(nums);
        return result;
    }
    public void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums);
            path.remove(path.size()-1);
            used[i] = 0;
        }
    }
}
