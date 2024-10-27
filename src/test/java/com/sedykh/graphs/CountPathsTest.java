package com.sedykh.graphs;

import com.sedykh.TestUtils;
import com.sedykh.graphs.dfs.CountPaths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountPathsTest {

    /**
     * Input: grid = [
     * [0, 0, 0, 0],
     * [1, 1, 0, 0],
     * [0, 0, 0, 1],
     * [0, 1, 0, 0]
     * ]
     * Output:
     * 2
     */
    @Test
    void countPaths() {
        String input = """
                [
                  [0, 0, 0, 0],
                  [1, 1, 0, 0],
                  [0, 0, 0, 1],
                  [0, 1, 0, 0]
                ]""";
        int actual = new CountPaths().countPaths(TestUtils.parseToArray2dArray(input));
        Assertions.assertEquals(2, actual);
    }

    @Test
    void countPaths2() {
        String input = "[[0, 0, 0, 0]]";
        int actual = new CountPaths().countPaths(TestUtils.parseToArray2dArray(input));
        Assertions.assertEquals(1, actual);
    }

    @Test
    void countPaths3() {
        String input = "[[0, 0, 0, 0], [1, 1, 1, 0]]";
        int actual = new CountPaths().countPaths(TestUtils.parseToArray2dArray(input));
        Assertions.assertEquals(1, actual);
    }

    @Test
    void countPaths4() {
        String input = "[[0, 0, 0, 0], [1, 1, 0, 0]]";
        int actual = new CountPaths().countPaths(TestUtils.parseToArray2dArray(input));
        Assertions.assertEquals(2, actual);
    }
}