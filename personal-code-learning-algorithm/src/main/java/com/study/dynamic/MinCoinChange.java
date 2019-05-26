package com.study.dynamic;

import java.util.Objects;

/**
 *
 * 最少的零钱兑换个数
 * 定义dp[n]表示兑换n元需要的最小硬币个数
 * dp[0] = 0 : 组成0元所需的最小硬币数为0
 * dp[i] = -1 : 没有硬币能组合成i元
 * 其中硬币类型：int coin = {1,3,5,...};
 * 则dp方程：dp[n] = min(dp[n-coin[0]]+1,dp[n-coin[1]]+1,...,dp[n-coin[coin.length-1]]+1);
 * 等价于：dp[n] = min(dp[n],dp[n-coin[i]]+1) 其中0<=i<=coin.size-1;
 * 则dp[n]即为所求
 */
public class MinCoinChange {

    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        MinCoinChange minCoinChange = new MinCoinChange();
        System.out.println(minCoinChange.coinChange(coins, 10));
    }

    private int coinChange(int[] coins, int amount){
        if (Objects.isNull(coins)) {
            return Integer.MIN_VALUE;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++) {
                if (i >= coins[j] && dp[i-coins[j]] != -1 && coins[j] >= 0) {
                    dp[i] = Integer.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
