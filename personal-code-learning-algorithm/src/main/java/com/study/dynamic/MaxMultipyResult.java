package com.study.dynamic;

import java.util.Objects;

/**
 *
 * 给定一组数组 求出连续子序列的最大乘积值
 * 定义dp[n]数组在n位置的最大乘积值
 * 则dp方程：dp[n] = max(dp[n-1]*a[n], a[n])
 * 最大值就在各个dp[n]中取得
 */
public class MaxMultipyResult {

    public static void main(String[] args){
        int[] origin = {0,12,-2,3,6,9,-1,20,10};
        MaxMultipyResult maxMultipyResult = new MaxMultipyResult();
        System.out.println(maxMultipyResult.getMaxMultipyResult(origin));
    }

    private int getMaxMultipyResult(int[] origin){
        if (Objects.isNull(origin)) {
            return -1;
        }
        if (origin.length == 1) {
            return origin[0];
        }
        int[] dp = new int[origin.length];
        dp[0] = origin[0];
        int res = Integer.MIN_VALUE;
        for (int i=1; i<origin.length; i++) {
            dp[i] = Integer.max(dp[i-1] * origin[i], origin[i]);
            res = Integer.max(res, dp[i]);
        }
        return res;
    }
}
