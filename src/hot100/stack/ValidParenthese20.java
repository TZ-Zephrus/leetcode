package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-11
 */
public class ValidParenthese20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char oldC = 0;
            if (!deque.isEmpty()) {
                oldC = deque.peek();
            }
            if ((oldC == '[' && c == ']') || (oldC == '(' && c == ')') || (oldC == '{' && c == '}')) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        if (deque.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
