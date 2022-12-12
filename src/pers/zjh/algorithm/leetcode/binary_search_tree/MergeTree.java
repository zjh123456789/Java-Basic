package pers.zjh.algorithm.leetcode.binary_search_tree;


/**
 * @author jinghui.zhu
 * @description 合并二叉树
 * @createTime 2022/9/30 5:35 PM
 */
public class MergeTree {

    /**
     * 递归解法
     *
     * @param root1 树1
     * @param root2 树2
     * @return 合并树节点之后的树
     */
    public TreeNode mergeTreeNode(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        TreeNode mergeTreeNode = new TreeNode(root1.val + root2.val);
        mergeTreeNode.left = mergeTreeNode(root1.left, root2.left);
        mergeTreeNode.right = mergeTreeNode(root1.right, root2.right);
        return mergeTreeNode;
    }
}