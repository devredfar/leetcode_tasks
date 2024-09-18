package com.sedykh.backtracking;

/**
 * 79. Word Search
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {

    char[][] board = null;
    boolean[][] used = null;
    String word = null;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.used = new boolean[board.length][board[0].length];
        boolean result = false;
        for (int i = 0; i < board.length && !result; i++) {
            for (int j = 0; j < board[0].length && !result; j++) {
                result = backtracking(i, j, 0);
            }

        }
        return result;
    }

    public boolean backtracking(int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length) {
            return false;
        }
        if (used[i][j]) {
            return false;
        }
        char charToFind = word.charAt(index);
        if (board[i][j] == charToFind) {
            used[i][j] = true;
            int nextIndex = index + 1;
            boolean backtracking = backtracking(i - 1, j, nextIndex)
                    || backtracking(i + 1, j, nextIndex)
                    || backtracking(i, j - 1, nextIndex)
                    || backtracking(i, j + 1, nextIndex);
            used[i][j] = false;
            return backtracking;
        } else {
            return false;
        }
    }
}
