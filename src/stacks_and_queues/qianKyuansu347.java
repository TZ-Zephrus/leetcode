package stacks_and_queues;

import java.util.*;

public class qianKyuansu347 {
    public static void main(String[] args) {
        int num[] = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(num, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //Map用来统计元素出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        //PriorityQueue生成一个小顶堆，小顶堆需要用Comparator实现
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            //pq未满时才可以添加
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            //pq满时，需要先判断是否要弹出队首元素，才可以添加
            } else if (entry.getValue() > pq.peek()[1]) {
                pq.poll();
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
