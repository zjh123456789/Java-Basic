package pers.zjh.algorithm.leetcode.binary_search_tree;

import lombok.Data;

/**
 * TreeNode
 *
 * @author jinghui.zhu
 * @createTime 2022/12/9 5:03 PM
 */
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}