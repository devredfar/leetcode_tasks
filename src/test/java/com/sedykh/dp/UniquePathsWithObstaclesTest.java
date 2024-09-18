package com.sedykh.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsWithObstaclesTest {

    @Test
    void uniquePathsWithObstacles() {
        int actual = new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[3][7]);
        assertEquals(28, actual);
    }

    @Test
    void uniquePathsWithObstacles2() {
        int actual = new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                });
        assertEquals(2, actual);
    }

    @Test
    void uniquePathsWithObstacles3() {
        int actual = new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]
                {
                        {0, 1},
                        {0, 0},
                });
        assertEquals(1, actual);
    }
}

