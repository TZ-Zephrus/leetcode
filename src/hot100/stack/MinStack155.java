package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-11
 */
public class MinStack155 {
    class MinStack {
        Deque<int[]> deque;

        public MinStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int val) {
            if (deque.isEmpty()) {
                deque.push(new int[]{val, val});
            } else {
                int[] peek = deque.peek();
                int min = Math.min(peek[1], val);
                deque.push(new int[]{val, min});
            }
        }

        public void pop() {
            deque.pop();
        }

        public int top() {
            int[] peek = deque.peek();
            return peek[0];
        }

        public int getMin() {
            int[] peek = deque.peek();
            return peek[1];
        }
    }
}
