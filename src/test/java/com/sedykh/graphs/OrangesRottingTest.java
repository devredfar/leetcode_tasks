package com.sedykh.graphs;

import com.sedykh.graphs.bfs.OrangesRotting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrangesRottingTest {

    @Test
    void orangesRotting_MySolutionDFS() {
        int[][] board = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int actual = new OrangesRotting.MySolutionDFS().orangesRotting(board);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void orangesRotting_MySolutionDFS_2() {
        int[][] board = {{0, 2}};
        int expected = 0;
        int actual = new OrangesRotting.MySolutionDFS().orangesRotting(board);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void orangesRotting_DFS() {
        int[][] board = {{2,1,1},{1,1,0},{0,1,1}};
        int expected = 4;
        int actual = new OrangesRotting.DFS().orangesRotting(board);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void orangesRotting_DFS_2() {
        int[][] board = {{0,2}};
        int expected = 0;
        int actual = new OrangesRotting.MySolutionDFS().orangesRotting(board);
        Assertions.assertEquals(expected, actual);
    }
}