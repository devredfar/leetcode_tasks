package com.sedykh.graphs.bfs;

import java.util.LinkedList;
import java.util.Set;

/**
 * 1091. Shortest Path in Binary Matrix
 * <p>
 * Given an n r n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected
 * (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 * <p>
 * DFS + store path length in queue.
 */
public class ShortestPathBinaryMatrix {

    private static final Set<int[]> directions = Set.of(
            new int[]{-1, -1},
            new int[]{-1, 0},
            new int[]{-1, +1},
            new int[]{0, -1},
            new int[]{0, +1},
            new int[]{+1, -1},
            new int[]{+1, 0},
            new int[]{+1, +1}
    );
    boolean[][] visited;
    int n;
    LinkedList<Coordinates> queue;

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length - 1;

        if (grid[0][0] == 1 || grid[n][n] == 1) {
            return -1;
        }

        if (n == 0) {
            return 1;
        }

        queue = new LinkedList<>();
        visited = new boolean[n + 1][n + 1];
        visited[0][0] = true;
        queue.add(new Coordinates(0, 0, 1));

        while (!queue.isEmpty()) {
            Coordinates coordinates = queue.pollFirst();
            int row = coordinates.r();
            int column = coordinates.c();
            int path = coordinates.path();

            if (row == n && column == n) {
                return path;
            }
            path++;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];
                if (newRow > n || newRow < 0 || newColumn > n || newColumn < 0) {
                    continue;
                }
                if (grid[newRow][newColumn] == 1) {
                    continue;
                }
                if (!visited[newRow][newColumn]) {
                    queue.addLast(new Coordinates(newRow, newColumn, path));
                    visited[newRow][newColumn] = true;
                }
            }

        }
        return -1;
    }


    record Coordinates(int r, int c, int path) {
    }
}
