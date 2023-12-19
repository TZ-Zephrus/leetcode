package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetTWO90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i>startIndex && nums[i] == nums[i-1]){
                continue;
            }
            subSet.add(nums[i]);
            result.add(new ArrayList<>(subSet));
            backtrack(nums, i+1);
            subSet.remove(subSet.size()-1);
        }
    }


}
