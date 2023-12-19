package stacks_and_queues;

import java.util.Stack;

public class zhanshixianduilie232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    static class MyQueue {
        Stack<Integer> instack = new Stack<>();
        Stack<Integer> outstack = new Stack<>();
        public MyQueue() {
        }

        public void push(int x) {
            instack.push(x);
        }

        public int pop() {
            if (outstack.empty()) {
                while (!instack.empty()) {
                    outstack.push(instack.pop());
                }
                return outstack.pop();
            } else {
                return outstack.pop();
            }
        }

        public int peek() {
            if (outstack.empty()) {
                while (!instack.empty()) {
                    outstack.push(instack.pop());
                }
                return outstack.peek();
            } else {
                return outstack.peek();
            }
        }

        public boolean empty() {
            return instack.empty() && outstack.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
