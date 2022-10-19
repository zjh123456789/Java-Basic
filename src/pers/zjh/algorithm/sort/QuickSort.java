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

    /**
     * 快速排序
     *
     * @param a     待排序的数组
     * @param left  数组的左边界(例如, 从起始位置开始排序, 则left=0)
     * @param right 数组的右边界(例如, 排序截至到数组末尾, 则right=a.length-1)
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = a[i];
            while (i < j) {
                // 从右边起, 找到一个比 x 小的值
                while (i < j && a[j] >= x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                // 从左边起, 找到一个比 x 大或者等于的值
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

}
