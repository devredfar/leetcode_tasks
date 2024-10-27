package com.sedykh.graphs.bfs;

import java.util.LinkedList;

/**
 * 994. Rotting Oranges
 * <p>
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange. Every minute, any
 * fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
 * -1.
 */
public class OrangesRotting {

    public static int fresh = 1;
    public static int rotten = 2;

    public static class MySolutionDFS {

        public int orangesRotting(int[][] grid) {
            LinkedList<int[]> rottenTomatoes = new LinkedList<>();
            int freshCount = 0;
            int cols = grid[0].length;
            int rows = grid.length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == rotten) {
                        rottenTomatoes.add(new int[]{i, j});
                    }
                    if (grid[i][j] == fresh) {
                        freshCount++;
                    }
                }
            }

            int stepNumber = 0;

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!rottenTomatoes.isEmpty() && freshCount != 0) {
                stepNumber++;
                int rottenTomatoesStep = rottenTomatoes.size();
                for (int i = 0; i < rottenTomatoesStep; i++) {
                    int[] rottenTomato = rottenTomatoes.poll();
                    int r = rottenTomato[0], c = rottenTomato[1];
                    for (int[] dir : dirs) {
                        int x = r + dir[0], y = c + dir[1];
                        if (0 <= x && x < rows && 0 <= y && y < cols && grid[x][y] == 1) {
                            grid[x][y] = 2;
                            rottenTomatoes.add(new int[]{x, y});
                            freshCount--;
                        }
                    }
                }
            }

            return freshCount == 0 ? stepNumber : -1;
        }
    }


    public static class DFS {

        public int orangesRotting(int[][] grid) {
            var result = 0;
            int cols = grid[0].length;
            int rows = grid.length;
            int[][] rottenSpeed = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == rotten) {
                        dfs(grid, i, j, rottenSpeed, 0);
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == fresh) {
                        int rottenSpeedCurrent = rottenSpeed[i][j];
                        if (rottenSpeedCurrent == 0) {
                            return -1;
                        } else {
                            result = Math.max(result, rottenSpeedCurrent);
                        }
                    }
                }
            }
            return result;
        }

        private void dfs(int[][] grid, int row, int col, int[][] rottenSpeed, int tick) {
            if (row < 0 || col < 0) {
                return;
            }
            if (row >= grid.length || col >= grid[0].length) {
                return;
            }
            int nextTick = tick + 1;

            if (tick == 0) {
                runNextSearch(grid, row, col, rottenSpeed, nextTick);
                return;
            }
            if (grid[row][col] != fresh) {
                return;
            }
            if (rottenSpeed[row][col] == 0 || rottenSpeed[row][col] > tick) {
                rottenSpeed[row][col] = tick;
                runNextSearch(grid, row, col, rottenSpeed, nextTick);
            }

        }

        private void runNextSearch(int[][] grid, int row, int col, int[][] rottenSpeed, int nextTick) {
            dfs(grid, row + 1, col, rottenSpeed, nextTick);
            dfs(grid, row - 1, col, rottenSpeed, nextTick);
            dfs(grid, row, col + 1, rottenSpeed, nextTick);
            dfs(grid, row, col - 1, rottenSpeed, nextTick);
        }
    }
}
