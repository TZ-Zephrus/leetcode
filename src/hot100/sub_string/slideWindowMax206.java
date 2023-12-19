package hot100.sub_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class slideWindowMax206 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int left = 1;
        int[] result = new int[nums.length - k + 1];
        result[0] = myQueue.peek();
        for (int right = k; right < nums.length; right++) {
            myQueue.pop(nums[left-1]);
            myQueue.push(nums[right]);
            result[left] = myQueue.peek();
            left++;
        }
        return result;
    }




    class MyQueue {
        Deque<Integer> deque = new ArrayDeque<>();

        public void pop(int num) {
            Integer i = deque.peekFirst();
            if (i == num) {
                deque.removeFirst();
            }
        }

        public void push(int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.removeLast();
            }
            deque.addLast(num);
        }

        public int peek() {
            return deque.peekFirst();
        }
    }
}
