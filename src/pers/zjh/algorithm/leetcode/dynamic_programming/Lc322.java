package pers.zjh.algorithm.leetcode.dynamic_programming;


import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author jinghui.zhu
 * @createTime 2023/1/2 4:11 PM
 */
public class Lc322 {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        int minCount = coinChange(coins, amount);
        System.out.println("最小硬币数：" + minCount);
    }

    public static int coinChange(int[] coins, int amount) {
        // solution1 dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}