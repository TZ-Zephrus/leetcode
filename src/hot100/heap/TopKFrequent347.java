package hot100.heap;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class TopKFrequent347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> deque = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (deque.size() < k) {
                deque.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (deque.peek()[1] < entry.getValue()) {
                    deque.poll();
                    deque.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            result[i] = deque.poll()[0];
        }
        return result;
    }
}
