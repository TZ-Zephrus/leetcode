package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class huadongchuangkou239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Que que = new Que();
        int j = 0;
        for (int i = 0; i < k; i++) {
            que.push(nums[i]);

        }
        result[j++] = que.getMax();
        for (int i = k; i < nums.length; i++) {
            que.pop(nums[i-k]);
            que.push(nums[i]);
            result[j++] = que.getMax();
        }
        return result;

    }

    static class Que {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        public void pop(int val) {
            if (!arrayDeque.isEmpty() && arrayDeque.peekFirst() == val) {
                arrayDeque.pollFirst();
            }
        }


        public void push(int val) {
            while (!arrayDeque.isEmpty() && arrayDeque.peekLast() < val) {
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(val);
        }

        public int getMax() {
            return arrayDeque.peekFirst();
        }
    }
}
