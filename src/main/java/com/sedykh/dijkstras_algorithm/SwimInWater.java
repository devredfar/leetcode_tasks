package com.sedykh.dijkstras_algorithm;

import java.util.PriorityQueue;
import java.util.Set;

/**
 * 778. Swim in Rising Water
 * <p>
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i,
 * j).
 * <p>
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another
 * 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim
 * infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square
 * (0, 0).
 */
public class SwimInWater {

    private static final Set<int[]> directions = Set.of(
        new int[]{-1, 0},
        new int[]{0, -1},
        new int[]{0, +1},
        new int[]{+1, 0}
    );

    public int swimInWater(int[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        PriorityQueue<int[]> backlog = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[maxRows][maxCols];

        // new int[]{ row, col, elevation}
        backlog.add(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!backlog.isEmpty()) {
            int[] current = backlog.poll();
            if (current[0] == maxRows - 1 && current[1] == maxCols - 1) {
                return current[2];
            }
            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                int max = Math.max(grid[newRow][newCol], current[2]);
                backlog.add(new int[]{newRow, newCol, max});
            }
        }
        return -1;
    }
}
