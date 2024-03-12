package hot100.double_pointer;

import java.util.ArrayDeque;
import java.util.Deque;

public class trapRain42 {
    public int trap(int[] height) {
        int i = 0;
        int j = 0;
        int result = 0;
        int part = 0;
        while (j < height.length) {
            if (height[j] < height[i]) {
                part += height[i] - height[j];
            } else {
                result += part;
                part = 0;
                i = j;
            }
            j++;
        }


        //反向
        i = height.length-1;
        j = height.length-1;
        part = 0;
        while (i >= 0) {
            if (height[i] <= height[j]) {
                part += height[j] - height[i];
            } else {
                result += part;
                part = 0;
                j = i;
            }
            i--;
        }
        return result;
    }


    // 单调栈法
    public int trap2(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                Integer index = deque.pop();
                if (!deque.isEmpty()) {
                    int temp = (Math.min(height[i], height[deque.peek()]) - height[index]) * (i - deque.peek() - 1);
                    sum = sum + temp;
                }
            }
            deque.push(i);
        }
        return sum;
    }
}
