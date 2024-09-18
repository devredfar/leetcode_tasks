package com.sedykh.graphs;

/**
 * 200. Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
 * islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 */
public class NumIslands {

    private int count = 0;

    public int numIslands(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    numIslands(grid, row, col);
                }
            }
        }
        return count;
    }

    private void numIslands(char[][] grid, int row, int col) {
        if (!isWater(grid, row, col)) {
            grid[row][col] = '0';
            numIslands(grid, row + 1, col);
            numIslands(grid, row, col + 1);
            numIslands(grid, row - 1, col);
            numIslands(grid, row, col - 1);
        }
    }

    private boolean isWater(char[][] grid, int row, int col) {
        if (row < 0 || col < 0) {
            return true;
        }
        if (row >= grid.length || col >= grid[0].length) {
            return true;
        }
        return grid[row][col] == '0';
    }
}
