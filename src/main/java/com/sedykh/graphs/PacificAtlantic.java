package com.sedykh.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * <p>
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
 * touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
 * heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and
 * west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any
 * cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell
 * (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int oceanHeight = -1;

        int cols = heights[0].length;
        int rows = heights.length;

        boolean[][] atlantic = new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, oceanHeight, atlantic);
            dfs(heights, row, cols - 1, oceanHeight, pacific);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, oceanHeight, atlantic);
            dfs(heights, rows - 1, col, oceanHeight, pacific);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] atlantic) {
        if (row < 0 || col < 0) {
            return;
        }
        if (row >= heights.length || col >= heights[0].length) {
            return;
        }

        if (atlantic[row][col]) {
            return;
        }

        int height = heights[row][col];

        if (height < prevHeight) {
            return;
        }

        atlantic[row][col] = true;

        dfs(heights, row, col + 1, height, atlantic);
        dfs(heights, row, col - 1, height, atlantic);
        dfs(heights, row + 1, col, height, atlantic);
        dfs(heights, row - 1, col, height, atlantic);
    }
}
