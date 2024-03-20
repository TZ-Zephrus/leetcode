package hot100.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-18
 */
public class LongestValidParenthese32 {
    // 栈
    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);   // 塞入一个-1用于计算长度，并且还能避免空指针
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (deque.peek() == -1) {
                deque.push(i);
            } else {
                if (s.charAt(i) == '(') {
                    deque.push(i);
                    continue;
                }
                if (s.charAt(deque.peek()) == '(') {
                    deque.pop();
                    result = Math.max(result, i - deque.peek());
                } else {
                    deque.push(i);
                }
            }
        }
        return result;
    }
}
