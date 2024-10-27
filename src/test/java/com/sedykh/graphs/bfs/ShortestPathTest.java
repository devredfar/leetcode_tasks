package com.sedykh.graphs.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathTest {

    /**
     * Input: grid = [
     * [0, 0, 0, 0],
     * [1, 1, 0, 0],
     * [0, 0, 0, 1],
     * [0, 1, 0, 0]
     * ]
     * <p>
     * Output:
     * 6
     */
    @Test
    void shortestPath() {
        int actual = new ShortestPath().shortestPath(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        });
        assertEquals(6, actual);
    }

    @Test
    void shortestPath1() {
        int actual = new ShortestPath().shortestPath(new int[][]{
                {0, 0, 0, 0}
        });
        assertEquals(3, actual);
    }

    @Test
    void shortestPath2() {
        int actual = new ShortestPath().shortestPath(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 0},
        });
        assertEquals(4, actual);
    }
}