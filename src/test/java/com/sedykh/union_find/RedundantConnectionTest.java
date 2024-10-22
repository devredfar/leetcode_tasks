package com.sedykh.union_find;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RedundantConnectionTest {

    /**
     * Input: edges = [[1,2],[1,3],[2,3]]
     * Output: [2,3]
     */
    @Test
    void findRedundantConnection() {
        int[][] edges = TestUtils.parseToArray2dArray("[[1,2],[1,3],[2,3]]");
        int[] actual = new RedundantConnection().findRedundantConnection(edges);
        assertArrayEquals(new int[]{2, 3}, actual);
    }

    /**
     * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
     * Output: [1,4]
     */
    @Test
    void findRedundantConnection2() {
        int[][] edges = TestUtils.parseToArray2dArray("[[1,2],[2,3],[3,4],[1,4],[1,5]]");
        int[] actual = new RedundantConnection().findRedundantConnection(edges);
        assertArrayEquals(new int[]{1, 4}, actual);
    }
}