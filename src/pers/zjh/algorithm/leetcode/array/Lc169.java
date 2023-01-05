package pers.zjh.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author jinghui.zhu
 * @createTime 2023/1/5 7:43 PM
 */
public class Lc169 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        int maxCount = getMaxCount(nums2);
        System.out.println("出现次数超过一半的数字：" + maxCount);

    }

    public static int getMaxCount(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}