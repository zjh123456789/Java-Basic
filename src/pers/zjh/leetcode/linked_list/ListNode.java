package pers.zjh.leetcode.linked_list;

/**
 * 单向链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x){
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
