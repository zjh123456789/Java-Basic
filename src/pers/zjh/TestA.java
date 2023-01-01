package pers.zjh;

import java.util.Scanner;

/**
 * TODO
 *
 * @author jinghui.zhu
 * @createTime 2022/12/27 9:18 PM
 */
public class TestA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            String res = reverse(s);
            System.out.println(res);
        }
    }

    /**
     * 单词逆序输出字符串
     *
     * @param s 入参s
     * @return 单词逆序之后的字符串s
     */
    public static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        String str = "";
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || chars[i] == ',' || chars[i] == '.' || chars[i] == '?') {
                for (int j = i-1; j >= index; j--) {
                    str += chars[j];
                }
                if (chars[i] == ' ') {
                    str += " ";
                } else {
                    str += chars[i];
                }
                index = i + 1;
            }
        }
        for (int i = chars.length-1; i >= index; i--) {
            if (chars[i] != ',' && chars[i] != '.' && chars[i] != '?') {
                str += chars[i];
            }
        }
        return str;
    }
}