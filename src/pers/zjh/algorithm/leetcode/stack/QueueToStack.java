package pers.zjh.algorithm.leetcode.stack;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jinghui.zhu
 * @description 用两个队列实现栈
 * @createTime 2022/9/21 4:05 PM
 */
public class QueueToStack {

    public static void main(String[] args) {

        InnerQueueToStack innerQueueToStack = new InnerQueueToStack();
        innerQueueToStack.push(1);
        innerQueueToStack.push(2);
        innerQueueToStack.push(3);
        System.out.println(innerQueueToStack.pop());
        System.out.println(innerQueueToStack.pop());
        System.out.println(innerQueueToStack.pop());
        System.out.println(innerQueueToStack.empty());
    }


    private static class InnerQueueToStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public InnerQueueToStack() {
            queue1 = new ArrayDeque();
            queue2 = new ArrayDeque();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}