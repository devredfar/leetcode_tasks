package com.sedykh.graphs;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SurroundedRegionsTest {

    @Test
    void solve3() {
        char[][] board = {{'O'}};
        char[][] expectedBoard = {{'O'}};
        new SurroundedRegions().solve(board);
        boolean equals = Arrays.deepEquals(board, expectedBoard);
        Assertions.assertTrue(equals);
    }
    @Test
    void solve() {
        char[][] board = {{'X'}};
        char[][] expectedBoard = {{'X'}};
        new SurroundedRegions().solve(board);
        boolean equals = Arrays.deepEquals(board, expectedBoard);
        Assertions.assertTrue(equals);
    }

    @Test
    void solve2() {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] expectedBoard = {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
        new SurroundedRegions().solve(board);
        boolean equals = Arrays.deepEquals(board, expectedBoard);
        Assertions.assertTrue(equals);
    }
}