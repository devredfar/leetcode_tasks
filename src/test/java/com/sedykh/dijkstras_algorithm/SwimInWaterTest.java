package com.sedykh.dijkstras_algorithm;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwimInWaterTest {

    @Test
    void swimInWater() {
        int[][] grid = TestUtils.parseToArray2dArray("[[0,2],[1,3]]");
        int actual = new SwimInWater().swimInWater(grid);
        Assertions.assertEquals(3, actual);
    }

    @Test
    void swimInWater2() {
        int[][] grid = TestUtils.parseToArray2dArray("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        int actual = new SwimInWater().swimInWater(grid);
        Assertions.assertEquals(16, actual);
    }
}