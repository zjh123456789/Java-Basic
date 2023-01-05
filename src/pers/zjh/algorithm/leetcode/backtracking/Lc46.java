package pers.zjh.algorithm.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author jinghui.zhu
 * @createTime 2023/1/4 7:05 PM
 */
public class Lc46 {

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 2, 3 };

        Lc46 lc46 = new Lc46();
        List<List<Integer>> permute = lc46.permute(a);
        System.out.println(permute);
    }

    /**
     * 最终结果集合
     */
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 定义单次结果list
        LinkedList<Integer> list = new LinkedList<>();
        // 定义是否路径已被覆盖
        boolean[] bs = new boolean[nums.length];
        backtrack(nums, list, bs);
        return res;
    }

    public void backtrack (int[] nums, LinkedList<Integer> list, boolean[] bs) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (bs[i]) {
                continue;
            }

            bs[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, bs);
            bs[i] = false;
            list.removeLast();
        }
    }
}