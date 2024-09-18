package com.sedykh.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumIslandsTest {

    @Test
    void numIslands1() {
        char[][] grid = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int actual = new NumIslands().numIslands(grid);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void numIslands2() {
        char[][] grid = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int actual = new NumIslands().numIslands(grid);
        Assertions.assertEquals(3, actual);
    }
}