package stacks_and_queues;

import java.util.Stack;

public class youxiaokuohao20 {
    public static void main(String[] args) {
        String s = "(((()))())";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> stack.push('(');
                case '[' -> stack.push('[');
                case '{' -> stack.push('{');
                case ')' -> {
                    if (stack.empty() || stack.peek() != '(') {
                        return false;
                    } else stack.pop();
                }
                case ']' -> {
                    if (stack.empty() || stack.peek() != '[') {
                        return false;
                    } else stack.pop();
                }
                case '}' -> {
                    if (stack.empty() || stack.peek() != '{') {
                        return false;
                    } else stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
