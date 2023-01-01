package pers.zjh.algorithm.leetcode.array;

/**
 * 26. 删除有序数组中的重复项
 *
 * @author jinghui.zhu
 * @createTime 2023/1/1 12:50 PM
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 5};
        int res = removeDuplicates(a);
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums) {
        // 快慢指针
        int preIndex = 0, behindIndex = 0;
        int arrayLength = nums.length;
        int res = 0;
        while (preIndex < arrayLength && behindIndex < arrayLength) {
            if (preIndex == behindIndex) {
                preIndex++;
            } else {
                if (nums[preIndex] == nums[behindIndex]) {
                    for (int i = preIndex; i < nums.length - 1; i++) {
                        nums[i] = nums[i+1];
                    }
                    arrayLength--;
                } else {
                    preIndex++;
                    behindIndex++;
                    res++;
                }
            }
        }
        return res+1;
    }
}