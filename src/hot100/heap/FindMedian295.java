package hot100.heap;

import java.util.PriorityQueue;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-14
 */
public class FindMedian295 {
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianFinder() {
            // 左是大顶堆
            left = new PriorityQueue<>((o1, o2) -> o2-o1);
            // 右是小顶堆
            right = new PriorityQueue<>((o1, o2) -> o1-o2);
        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                if (right.isEmpty()) {
                    left.add(num);
                } else if (right.peek() > num) {
                    left.add(num);
                } else {
                    Integer poll = right.poll();
                    left.add(poll);
                    right.add(num);
                }
            } else {
                // size不等时，只有可能left大于right
                if (left.peek() <= num) {    // 用left.peek()做判断
                    right.add(num);
                } else {
                    Integer poll = left.poll();
                    left.add(num);
                    right.add(poll);
                }
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek())/2.0;
            } else {
                return left.peek();
            }
        }
    }
}
