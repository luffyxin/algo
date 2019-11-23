package com.dx.leetcode;

public class lee70 {

    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[1] + dp[2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
