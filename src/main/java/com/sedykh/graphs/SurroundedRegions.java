package com.sedykh.graphs;

/**
 * 130. Surrounded Regions
 * <p>
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * <p>
 * Connect: A cell is connected to adjacent cells horizontally or vertically. Region: To form a region connect every 'O'
 * cell. Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the
 * region cells are on the edge of the board. A surrounded region is captured by replacing all 'O's with 'X's in the
 * input matrix board.
 */
public class SurroundedRegions {

    public static final char SURROUNDED_REGION = 'S';

    public void solve(char[][] board) {

        int cols = board[0].length;
        int rows = board.length;

        for (int i = 0; i < cols; i++) {
            dfs(board, 0, i);
        }

        for (int i = 0; i < cols; i++) {
            dfs(board, rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
        }

        for (int i = 0; i < rows; i++) {
            dfs(board, i, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0) {
            return;
        }
        if (row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = SURROUNDED_REGION;

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);

        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
