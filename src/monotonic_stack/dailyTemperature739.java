package monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class dailyTemperature739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        monoStack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!monoStack.isEmpty() && temperatures[monoStack.peek()] < temperatures[i]) {
                Integer pop = monoStack.pop();
                result[pop] = i-pop;
            }
            monoStack.push(temperatures[i]);
        }
        return result;
    }
}
