package com.sedykh.prims_min_spannig_tree;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MinCostConnectPointsTest {

    @Nested
    class MySolution {

        @Test
        void minCostConnectPoints() {
            int[][] points = TestUtils.parseToArray2dArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]");
            int actual = new MinCostConnectPoints.MySolution().minCostConnectPoints(points);
            Assertions.assertEquals(20, actual);
        }

        @Test
        void minCostConnectPoint2() {
            int[][] points = TestUtils.parseToArray2dArray("[[3,12],[-2,5],[-4,1]]");
            int actual = new MinCostConnectPoints.MySolution().minCostConnectPoints(points);
            Assertions.assertEquals(18, actual);
        }
    }

    @Nested
    class Neetcode {

        @Test
        void minCostConnectPoints() {
            int[][] points = TestUtils.parseToArray2dArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]");
            int actual = new MinCostConnectPoints.Neetcode().minCostConnectPoints(points);
            Assertions.assertEquals(20, actual);
        }

        @Test
        void minCostConnectPoint2() {
            int[][] points = TestUtils.parseToArray2dArray("[[3,12],[-2,5],[-4,1]]");
            int actual = new MinCostConnectPoints.Neetcode().minCostConnectPoints(points);
            Assertions.assertEquals(18, actual);
        }
    }

}