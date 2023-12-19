package stacks_and_queues;


//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
//
//请你计算该表达式。返回一个表示表达式值的整数。
//
//注意：
//
//有效的算符为 '+'、'-'、'*' 和 '/' 。
//每个操作数（运算对象）都可以是一个整数或者另一个表达式。
//两个整数之间的除法总是 向零截断 。
//表达式中不含除零运算。
//输入是一个根据逆波兰表示法表示的算术表达式。
//答案及所有中间计算结果可以用 32 位 整数表示。

//    其实就是后缀运算符

import java.util.ArrayDeque;

public class nibolanbiaodashi150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                arrayDeque.push(arrayDeque.pop()+arrayDeque.pop());
            } else if ("-".equals(tokens[i])) {
                arrayDeque.push(-arrayDeque.pop() + arrayDeque.pop());
            } else if ("*".equals(tokens[i])) {
                arrayDeque.push(arrayDeque.pop()*arrayDeque.pop());
            } else if ("/".equals(tokens[i])) {
                int temp1 = arrayDeque.pop();
                int temp2 = arrayDeque.pop();
                arrayDeque.push(temp2/temp1);
            } else {
                arrayDeque.push(Integer.valueOf(tokens[i]));
            }
        }
        return arrayDeque.pop();
    }
}
