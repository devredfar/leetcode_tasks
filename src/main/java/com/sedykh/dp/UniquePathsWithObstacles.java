package com.sedykh.dp;

/**
 * 63. Unique Paths II
 * <p>
 * You are given an m x n integer array grid.
 * There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int maxCol = obstacleGrid[0].length;
        int maxRow = obstacleGrid.length;
        int[] memory = new int[maxCol];
        int[] lastRow = obstacleGrid[maxRow - 1];
        var isAnyObstacleOnRow = false;
        for (int i = lastRow.length - 1; i >= 0 && !isAnyObstacleOnRow; i--) {
            if (lastRow[i] == 0) {
                memory[i] = 1;
            } else {
                isAnyObstacleOnRow = true;
            }
        }
        for (int row = maxRow - 2; row >= 0; row--) {
            for (int col = maxCol - 1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    memory[col] = 0;
                } else if (col < maxCol - 1) {
                    memory[col] = memory[col] + memory[col + 1];
                }
            }
        }
        return memory[0];
    }
}