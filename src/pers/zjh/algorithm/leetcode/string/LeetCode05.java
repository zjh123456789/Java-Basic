package pers.zjh.algorithm.leetcode.string;

/**
 * 最长回文子串   Longest Palindromic Substring
 * difficulty: Medium
 *
 * @author jinghui.zhu
 * @date 2019/3/15 10:48
 */
public class LeetCode05 {

    public static void main(String[] args) {
        String s = "acbc";
        System.out.println("暴力破解: " + longestPalindrome(s));
        System.out.println("动态规划: " + dp(s));
    }

    /**
     * 暴力破解 时间复杂度 O（n三次方)
     */
    public static String longestPalindrome(String s){
        int length = s.length();
        String target = "";
        for (int i=0; i<length; i++){
            for (int j=i; j<length; j++){
                String substring = s.substring(i,j+1);
                if (palindrome(substring)){
                    if (substring.length() > target.length()){
                        target = substring;
                    }
                }
            }
        }
        return target;
    }

    /**
     * 判断一个字符串是否为回文串
     */
    public static boolean palindrome(String s){
        if (s == null){
            return false;
        }
        if (s.length() == 1){
            return true;
        }
        for (int i=0; i<s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划 先创建一个二维数组，初始值都为0 表示不是回文  1表示是回文
     *          正对角线上的值都为1， 因为单个字符必定是回文
     *          要判断 p[i][j] 是否为回文  可以从p[i+1][j-1] 入手
     *          那么 p[i][j] = 1 当且仅当 p[i+1][j-1] = 1 且 s[i] == s[j]
     *                       = 0  其余情况
     *          列从最前一列开始                  只需要判定 j>=i 的情况 字符串正着来一遍就可以了
     *          行从最后一行开始
     *
     * @param s 字符串
     * @return true/false
     */
    public static String dp(String s){
        int length = s.length();
        if (length == 1){
            return s;
        }

        // 创建一个空数组
        int[][] dy = new int[length][length];

        // 初始化数组值
        for (int i = 0; i < length; i++){
            for (int j = i ; j < length; j++){
                if (i == j){
                    dy[i][j] = 1;
                }else {
                    dy[i][j] = 0;
                }
            }
        }

        // 动态规划
        for (int i = length-1; i >= 0; i--){
            for (int j = i + 1; j < length; j++){
                if (j - i == 1){
                    if (s.charAt(i) == s.charAt(j)){
                        dy[i][j] = 1;
                    }else{
                        dy[i][j] = 0;
                    }
                }else {
                    if (dy[i+1][j-1] == 1 && (s.charAt(i) == s.charAt(j))){
                        dy[i][j] = 1;
                    }else{
                        dy[i][j] = 0;
                    }
                }
            }
        }

        // 设置变量
        String target = "";
        int num = 0;

        // 打印验证回文数组
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                System.out.printf("%s  ",dy[i][j]);
                if (dy[i][j] == 1){
                    if (j - i >= num){
                        target = s.substring(i,j+1);
                        num = j - i;
                    }
                }
            }
            System.out.printf("\n");
        }
        return target;
    }

}
