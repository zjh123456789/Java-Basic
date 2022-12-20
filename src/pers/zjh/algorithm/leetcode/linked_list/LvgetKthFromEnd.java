package pers.zjh.algorithm.leetcode.linked_list;

/**
 * 链表中倒数第k个节点
 *
 * @author jinghui.zhu
 * @createTime 2022/12/20 2:15 PM
 */
public class LvgetKthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = initListNode();

        ListNode kthFromEnd = getKthFromEnd(listNode, 2);
    }

    public static ListNode initListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        return listNode1;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode preNode = head, behindNode = head;
        while (preNode != null && k > 0) {
            preNode = preNode.next;
            k--;
        }

        while (preNode != null) {
            preNode = preNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }
}