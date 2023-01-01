package pers.zjh.data_structure.queue;

import java.util.PriorityQueue;

/**
 * 最大堆、最小堆
 *
 * @author jinghui.zhu
 * @createTime 2022/12/31 4:56 PM
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueueTest test = new PriorityQueueTest();
        PriorityQueue<ListNode> priorityQueue = test.make();

        // poll() 方法输出并且将该元素从堆里取出来
        System.out.println(priorityQueue.poll().val);
        System.out.println(priorityQueue.poll().val);
        System.out.println(priorityQueue.poll().val);
        System.out.println(priorityQueue.poll().val);
        System.out.println(priorityQueue.poll().val);

        // peek() 方法只输出第一个值
        System.out.println(priorityQueue.peek().val);
        System.out.println(priorityQueue.peek().val);
        System.out.println(priorityQueue.peek().val);
        System.out.println(priorityQueue.peek().val);
        System.out.println(priorityQueue.peek().val);

    }


    public PriorityQueue<ListNode> make() {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(3, (a, b) -> (a.val - b.val));
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        priorityQueue.add(listNode1);
        priorityQueue.add(listNode2);
        priorityQueue.add(listNode3);
        priorityQueue.add(listNode4);
        priorityQueue.add(listNode5);
        return priorityQueue;
    }

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x){
            val = x;
        }
    }
}