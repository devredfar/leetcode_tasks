package com.sedykh.prims_min_spannig_tree;

import com.sedykh.TestUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimsMinSpanningTreeTest {

    /**
     * n = 5 edges = [[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]] Output: 11
     */
    @Test
    void minimumSpanningTree() {
        ArrayList<List<Integer>> edges = TestUtils.parseToList("[[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]]");
        int actual = new PrimsMinSpanningTree().minimumSpanningTree(edges, 5);
        Assertions.assertEquals(11, actual);
    }
}

// [[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]]
// 0 -> 1(10),2(3)
// 1 -> 3(2)
// 2 -> 1(4),3(8),4(2)
// 3 -> 4(5)
