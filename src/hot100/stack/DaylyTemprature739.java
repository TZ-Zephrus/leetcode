package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DaylyTemprature739 {
    // 用单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                Integer index = deque.pop();
                result[index] = i-index;
            }
            deque.push(i);
        }
        return result;
    }
}
