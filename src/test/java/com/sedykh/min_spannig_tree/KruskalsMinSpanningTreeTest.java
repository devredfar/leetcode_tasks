package com.sedykh.min_spannig_tree;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KruskalsMinSpanningTreeTest {

    /**
     * n = 5 edges = [[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]] Output: 11
     */
    @Test
    void minimumSpanningTree() {
        ArrayList<List<Integer>> edges = TestUtils.parseToList("[[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]]");
        int actual = new KruskalsMinSpanningTree().minimumSpanningTree(edges, 5);
        Assertions.assertEquals(11, actual);
    }
}