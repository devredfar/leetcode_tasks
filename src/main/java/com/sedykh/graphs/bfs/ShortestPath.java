package com.sedykh.graphs.bfs;

/**
 * Matrix Breadth-First Search
 * You are given a binary matrix Grid where 0s represent land and 1s represent rocks that can not be traversed.
 * <p>
 * Return the length of the shortest path from the top-left corner of Grid to the bottom-right corner
 * such that all traversed cells are land cells. You may only move vertically or horizontally through land cells.
 * Note:
 * If there is no such path, return -1.
 * The length of a path is the number of moves from the starting cell to the ending cell.
 */
public class ShortestPath {
    public int shortestPath(int[][] grid) {
        if (grid == null) {
            return -1;
        }
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        var visited = new boolean[grid.length][grid[0].length];
        var queue = new java.util.LinkedList<int[]>();
        queue.add(new int[]{0, 0, 0});
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            int row = step[0];
            int col = step[1];
            if (row < 0 || row > grid.length - 1) {
                continue;
            }
            if (col < 0 || col > grid[0].length - 1) {
                continue;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            int distance = step[2];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                result = Math.min(result, distance);
            }
            if (grid[row][col] == 1) {
                continue;
            }
            queue.add(new int[]{row, col + 1, distance + 1});
            queue.add(new int[]{row, col - 1, distance + 1});
            queue.add(new int[]{row + 1, col, distance + 1});
            queue.add(new int[]{row - 1, col, distance + 1});
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
