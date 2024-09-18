package com.sedykh.kruskals_min_spannig_tree;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCostConnectPointsTest {

    @Test
    void minCostConnectPoints() {
        int[][] points = TestUtils.parseToArray2dArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]");
        int actual = new MinCostConnectPoints().minCostConnectPoints(points);
        Assertions.assertEquals(20, actual);
    }

    @Test
    void minCostConnectPoint2() {
        int[][] points = TestUtils.parseToArray2dArray("[[3,12],[-2,5],[-4,1]]");
        int actual = new MinCostConnectPoints().minCostConnectPoints(points);
        Assertions.assertEquals(18, actual);
    }

}