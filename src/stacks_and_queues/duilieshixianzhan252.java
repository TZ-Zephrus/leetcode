package stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

public class duilieshixianzhan252 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }


    //用两个队列
    static class MyStack1 {
        Queue<Integer> mainqueue = new LinkedList<>();
        Queue<Integer> subqueue = new LinkedList<>();

        public MyStack1() {

        }

        public void push(int x) {
            mainqueue.add(x);
        }

        public int pop() {
            while (mainqueue.size() > 1) {
                subqueue.add(mainqueue.remove());
            }
            int result = mainqueue.remove();
            while (!subqueue.isEmpty()) {
                mainqueue.add(subqueue.remove());
            }
            return result;
        }

        public int top() {
            int result = pop();
            mainqueue.add(result);
            return result;
        }

        public boolean empty() {
            return mainqueue.isEmpty();
        }
    }

    static class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        public MyStack() {
        }

        public void push(int x) {
            queue.add(x);
            int len = queue.size();
            while (len > 1) {
                queue.add(queue.remove());
                len--;
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
