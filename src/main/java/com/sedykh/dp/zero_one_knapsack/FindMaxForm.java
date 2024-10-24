package com.sedykh.dp.zero_one_knapsack;

/**
 * 474. Ones and Zeroes
 * <p>
 * You are given an array of binary strings strs and two integers m and n.
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * <p>
 * Constraints:
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] countedString = countZerosAndOnes(str);
            int zeros = countedString[0];
            int ones = countedString[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    int cacheWithoutThisString = cache[i - zeros][j - ones];
                    cache[i][j] = Math.max(cache[i][j], cacheWithoutThisString + 1);
                }
            }
        }
        return cache[m][n];
    }

    private int[] countZerosAndOnes(String str) {
        int zeros = 0;
        int ones = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') zeros++;
            if (c == '1') ones++;
        }
        return new int[]{zeros, ones};
    }
}
