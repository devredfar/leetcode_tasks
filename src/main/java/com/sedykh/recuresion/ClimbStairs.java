package com.sedykh.recuresion;

import java.util.Arrays;

public class ClimbStairs {
    public int climbStairsNaive(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairsNaive(n - 1) + climbStairsNaive(n - 2);
    }


    public int climbStairsMemoization(int n) {
        var memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsMemoization(n, memo);
    }

    private int climbStairsMemoization(int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int count = climbStairsMemoization(n - 1, memo) + climbStairsMemoization(n - 2, memo);
        memo[n] = count;
        return count;
    }

    public int climbStairsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //optimal
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int c;

        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
