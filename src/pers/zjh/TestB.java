package pers.zjh;

import java.util.Scanner;

/**
 * 空位中友好度的最大值
 *
 * @author jinghui.zhu
 * @createTime 2022/12/28 12:16 AM
 */
public class TestB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            int i = maxCount(s);
            System.out.println(i);
        }
    }

    public static int maxCount(String s) {
        int count = 0;
        int res = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                char c = chars[i];
                if (c == '2') {
                    res = Math.max(res, count);
                    count = 0;
                } else if (c == '1') {
                    count++;
                }
            }
        }
        return res;
    }
}