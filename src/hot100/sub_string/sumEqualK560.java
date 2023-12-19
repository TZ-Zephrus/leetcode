package hot100.sub_string;

import java.util.HashMap;

public class sumEqualK560 {
    public int subarraySum(int[] nums, int k) {
        //用来存前缀
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int num = 0;
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {
                num += hashMap.get(sum-k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0)+1);
        }
        return num;
    }
}
