package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        for (int i = 0; i < newHeights.length; i++) {
            while (!deque.isEmpty() && newHeights[deque.peek()] > newHeights[i]) {
                Integer index = deque.pop();
                // 这里就不需要if了
                int w = i - deque.peek() - 1;
                int h = newHeights[index];
                result = Math.max(result, w * h);
            }
            deque.push(i);
        }
        return result;
    }
}
