package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class increasingSubList491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subSet = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {

            if (hashSet.contains(nums[i]) || (!subSet.isEmpty() && nums[i] < subSet.get(subSet.size()-1))){
                continue;
            }
            hashSet.add(nums[i]);
            subSet.add(nums[i]);
            if (subSet.size() >= 2) {
                result.add(new ArrayList<>(subSet));
            }
            backtrack(nums, i + 1);
            subSet.remove(subSet.size()-1);
        }
    }

//    public boolean isBigger(List<Integer> list) {
//        if (list.get(list.size()-1) >= list.get(list.size()-2)) {
//            return true;
//        }
//        return false;
//    }
}
