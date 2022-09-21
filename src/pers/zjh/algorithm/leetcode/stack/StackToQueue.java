package pers.zjh.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author jinghui.zhu
 * @description 使用栈实现队列
 * @createTime 2022/9/21 11:22 AM
 */
public class StackToQueue {

    public static void main(String[] args) {
        InnerStackToQueue innerStackToQueue = new InnerStackToQueue();
        innerStackToQueue.add(1);
        innerStackToQueue.add(2);
        innerStackToQueue.add(3);
        System.out.println(innerStackToQueue.pop());
        System.out.println(innerStackToQueue.pop());
        System.out.println(innerStackToQueue.pop());
    }


    public static class InnerStackToQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public InnerStackToQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // 入队列
        public void add(int x) {
            if (stack1.isEmpty()) {
                stack1.add(x);
                return;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            stack1.add(x);
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
        }

        // 出队列
        public Integer pop() {
            if (!stack1.isEmpty()) {
                return stack1.pop();
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return null;
        }

        // 第一个元素
        public Integer peek() {
            if (!stack1.isEmpty()) {
                return stack1.peek();
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            return null;
        }

        // 是否为空
        public Boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}