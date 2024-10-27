package com.sedykh.graphs.dfs;

/**
 * Matrix Depth-First Search
 * You are given a binary matrix Grid where 0s represent land and 1s represent rocks that can not be traversed.
 * <p>
 * Return the number of unique paths from the top-left corner of Grid to the bottom-right corner such
 * that all traversed cells are land cells. You may only move vertically or horizontally through land cells.
 * For an individual unique path you cannot visit the same cell twice.
 */
public class CountPaths {
    public int countPaths(int[][] grid) {
        if (grid == null
                || grid.length == 0
                || grid[0][0] == 1
                || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(0, 0, grid, visited);
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        if (row < 0 || row > grid.length - 1) {
            return 0;
        }
        if (col < 0 || col > grid[0].length - 1) {
            return 0;
        }
        if (grid[row][col] == 1 || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int paths = dfs(row + 1, col, grid, visited)
                + dfs(row - 1, col, grid, visited)
                + dfs(row, col + 1, grid, visited)
                + dfs(row, col - 1, grid, visited);
        visited[row][col] = false;
        return paths;
    }
}
