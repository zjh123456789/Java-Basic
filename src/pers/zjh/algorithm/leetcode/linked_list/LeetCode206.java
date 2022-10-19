package pers.zjh.algorithm.leetcode.linked_list;

/**
 * 反转一个单链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2020/5/13 14:34:33
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode listNode = initListNode();
        ListNode newListNode = recursionReverseList(listNode);
        print(newListNode);
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

    // 第一种 遍历原链表 不断初始化node 然后一个个反向拼接
    private static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode listNode = new ListNode(head.val);
        while (null != head.next) {
            ListNode node = new ListNode(head.next.val);
            node.next = listNode;
            listNode = node;
            head = head.next;
        }
        return listNode;
    }

    // 第二种 递归
    private static ListNode recursionReverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newListNode = recursionReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;
    }

    // 第三种 在原链表上修改指针方向 不创建新的node
    private static ListNode thirdMethod(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            // 先把当前节点的下一个节点保存下来
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static void print(ListNode listNode) {
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
