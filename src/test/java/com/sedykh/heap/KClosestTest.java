package com.sedykh.heap;

import com.sedykh.TestUtils;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KClosestTest {

    /**
     * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]]
     */
    @Test
    void kClosest1() {
        int[][] points = TestUtils.parseToArray2dArray("[[1,3],[-2,2]]");
        int[][] expected = TestUtils.parseToArray2dArray("[[-2,2]]");
        int[][] actual = new KClosest().kClosest(points, 1);
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    /**
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]] The answer [[-2,4],[3,3]] would also be
     * accepted.
     */
    @Test
    void kClosest2() {
        int[][] points = TestUtils.parseToArray2dArray("[[3,3],[5,-1],[-2,4]]");
        int[][] expected1 = TestUtils.parseToArray2dArray("[[3,3],[-2,4]]");
        int[][] expected2 = TestUtils.parseToArray2dArray("[[-2,4],[3,3]]");
        int[][] actual = new KClosest().kClosest(points, 2);
        boolean firstSolution = Arrays.deepEquals(actual, expected1);
        boolean secondSolution = Arrays.deepEquals(actual, expected2);
        Assertions.assertTrue(firstSolution || secondSolution);
    }
}