package hot100.array;

import java.util.HashMap;

public class twoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{i, hashmap.get(target - nums[i])};
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }
}
