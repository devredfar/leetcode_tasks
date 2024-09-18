package com.sedykh.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsTest {

    @Test
    void uniquePaths_Optimal() {
        int actualResult = new UniquePaths.Optimal().uniquePaths(3, 7);
        assertEquals(28, actualResult);
    }

    @Test
    void uniquePaths_DPWithMemoizationTopDown() {
        int actualResult = new UniquePaths.DPWithMemoizationTopDown().uniquePaths(3, 7);
        assertEquals(28, actualResult);
    }

    @Test
    void uniquePaths_RecursiveApproach() {
        int actualResult = new UniquePaths.RecursiveApproach().uniquePaths(3, 7);
        assertEquals(28, actualResult);
    }
}