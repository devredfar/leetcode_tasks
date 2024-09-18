package com.sedykh.dp;

import java.util.Arrays;

/**
 * 62. Unique Paths
 * <p>
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {

    public static class Optimal {

        public int uniquePaths(int m, int n) {
            return uniquePaths(m, n, new int[n]);
        }

        private int uniquePaths(int maxRow, int maxCol, int[] storedRow) {
            Arrays.fill(storedRow, 1);
            for (int i = 1; i < maxRow; i++) {
                for (int j = maxCol - 2; j >= 0; j--) {
                    storedRow[j] = storedRow[j] + storedRow[j + 1];
                }
            }
            return storedRow[0];
        }
    }


    static class DPWithMemoizationTopDown {
        public int uniquePaths(int m, int n) {
            return uniquePaths(m, n, 0, 0, new int[m][n]);
        }

        private int uniquePaths(int maxRow, int maxCol, int row, int col, int[][] cache) {
            if (row == maxRow || col == maxCol) {
                return 0;
            }
            if (row == maxRow - 1 && col == maxCol - 1) {
                return 1;
            }
            if (cache[row][col] != 0) {
                return cache[row][col];
            }
            cache[row][col] = uniquePaths(maxRow, maxCol, row + 1, col, cache) +
                    uniquePaths(maxRow, maxCol, row, col + 1, cache);
            return cache[row][col];
        }
    }

    public static class RecursiveApproach {
        public int uniquePaths(int m, int n) {
            return uniquePaths(m, n, 0, 0);
        }

        private int uniquePaths(int maxRow, int maxCol, int row, int col) {
            if (row >= maxRow || col >= maxCol) {
                return 0;
            }
            if (row == maxRow - 1 && col == maxCol - 1) {
                return 1;
            }
            return uniquePaths(maxRow, maxCol, row + 1, col) +
                    uniquePaths(maxRow, maxCol, row, col + 1);
        }
    }

}
