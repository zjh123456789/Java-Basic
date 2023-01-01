package pers.zjh.algorithm.sort;

/**
 * 快速排序算法
 * https://blog.csdn.net/morewindows/article/details/6684558
 *
 * @author jinghui.zhu
 * @date 2019/3/11 14:54
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 2, 1, 5, 3};

        System.out.println("before sort: ");
        for (int item : a) {
            System.out.printf("%d ", item);
        }
        System.out.printf("%n");

        quickSort(a, 0, a.length - 1);

        System.out.println("after sort: ");
        for (int value : a) {
            System.out.printf("%d ", value);
        }
    }

    public static void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int x = doublePointerSwap(nums, startIndex, endIndex);
        quickSort(nums, startIndex, x - 1);
        quickSort(nums, x + 1, endIndex);
    }

    public static int doublePointerSwap(int[] nums, int startIndex, int endIndex) {
        int left = startIndex, right = endIndex;
        int pivot = nums[startIndex];

        while (left < right) {
            // 从右往左 直到遇到一个比 pivot 小的数字
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            // 填坑
            if (left < right) {
                nums[left++] = nums[right];
            }
            // 从左往右 直到遇到一个比 pivot 大的数字
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            // 填坑
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[right] = pivot;
        return right;
    }

}
