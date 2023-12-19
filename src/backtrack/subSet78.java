package backtrack;

import java.util.ArrayList;
import java.util.List;

public class subSet78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]);
            result.add(new ArrayList<>(subSet));
            backtrack(nums, i+1);
            subSet.remove(subSet.size()-1);
        }
    }
}
