package pers.zjh.algorithm.leetcode.heap;

import pers.zjh.algorithm.leetcode.linked_list.ListNode;

import java.util.PriorityQueue;

/**
 * 合并k个有序链表
 *
 * @author jinghui.zhu
 * @createTime 2022/12/31 5:32 PM
 */
public class LeetCode23 {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode listNode1 = initListNode(new int[]{1, 4, 5});
        ListNode listNode2 = initListNode(new int[]{1, 3, 4});
        ListNode listNode3 = initListNode(new int[]{2, 6});
        listNodes[0] = listNode1;
        listNodes[1] = listNode2;
        listNodes[2] = listNode3;

        ListNode mergeListNode = mergeKLists(listNodes);
        System.out.println("res: " + mergeListNode.val);
    }

    public static ListNode initListNode(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int a : array) {
            ListNode listNode = new ListNode(a);
            p.next = listNode;
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // 创建一个头虚拟节点
        ListNode dummy = new ListNode(-1);
        // 创建一个 p 用于指向后续的节点
        ListNode p = dummy;

        // 构建一个最小堆 按k个链表的元素 升序存储
        PriorityQueue<ListNode> priority = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 遍历链表数组，将每个链表的第一个元素放入最小堆中
        for (ListNode listNode : lists) {
            if (null != listNode) {
                priority.add(listNode);
            }
        }

        while (!priority.isEmpty()) {
            ListNode temp = priority.poll();
            p.next = temp;
            if (null != temp.next) {
                priority.add(temp.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}