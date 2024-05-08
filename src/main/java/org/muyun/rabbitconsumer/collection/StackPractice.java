package org.muyun.rabbitconsumer.collection;

import java.util.Stack;

// 栈 先进后出
public class StackPractice {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Fir");
        stack.push("Sec");
        stack.push("Thir");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
