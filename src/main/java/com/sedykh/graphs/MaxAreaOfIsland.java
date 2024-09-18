package com.sedykh.graphs;

/**
 * 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {

    public static class MySolution {

        private int maxArea = 0;
        private int currentArea = 0;

        public int maxAreaOfIsland(int[][] grid) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        currentArea = 0;
                        maxAreaOfIsland(grid, row, col);
                        maxArea = Math.max(maxArea, currentArea);
                    }
                }
            }
            return maxArea;
        }

        private void maxAreaOfIsland(int[][] grid, int row, int col) {
            if (!isWater(grid, row, col)) {
                currentArea += 1;
                grid[row][col] = 0;
                maxAreaOfIsland(grid, row + 1, col);
                maxAreaOfIsland(grid, row, col + 1);
                maxAreaOfIsland(grid, row - 1, col);
                maxAreaOfIsland(grid, row, col - 1);
            }
        }

        private boolean isWater(int[][] grid, int row, int col) {
            if (row < 0 || col < 0) {
                return true;
            }
            if (row >= grid.length || col >= grid[0].length) {
                return true;
            }
            return grid[row][col] == 0;
        }
    }

    public static class Optimal {

        public int maxAreaOfIsland(int[][] grid) {
            int rect = 0;
            int rowMax = grid.length;
            int colMax = grid[0].length;
            for (int row = 0; row < rowMax; row++) {
                for (int col = 0; col < colMax; col++) {
                    int rec = dfs(grid, row, col, rowMax, colMax);
                    if (rect < rec)
                        rect = rec;
                }
            }
            return rect;
        }

        public int dfs(int[][] grid, int row, int col, int rowMax, int colMax) {
            if (row < 0 || col < 0 || row >= rowMax || col >= colMax) {
                return 0;
            }
            if (grid[row][col] == 0)
                return 0;
            grid[row][col] = 0;
            int rect = 1;
            rect += dfs(grid, row - 1, col, rowMax, colMax);
            rect += dfs(grid, row, col - 1, rowMax, colMax);
            rect += dfs(grid, row + 1, col, rowMax, colMax);
            rect += dfs(grid, row, col + 1, rowMax, colMax);
            return rect;
        }
    }
}
