package com.sedykh.topological_sort;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class TopologicalSortTest {

    @Nested
    class MySolution {
        /**
         * Input: n = 6 edges = [[2,3], [3,1], [4,0], [4,1], [5,0], [5,2]] Output: [5, 4, 2, 3, 1, 0]
         */
        @Test
        void topologicalSort() {
            int[][] edges = TestUtils.parseToArray2dArray("[[2,3], [3,1], [4,0], [4,1], [5,0], [5,2]]");
            List<Integer> actual = new TopologicalSort.MySolution().topologicalSort(6, edges);
            Assertions.assertEquals(List.of(5, 4, 2, 3, 1, 0), actual);
        }

        /**
         * Input: n = 3 edges = [[0,1], [1,2], [2,0]] Output: []
         */

        @Test
        void topologicalSort2() {
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1], [1,2], [2,0]]");
            List<Integer> actual = new TopologicalSort.MySolution().topologicalSort(3, edges);
            Assertions.assertEquals(List.of(), actual);
        }
    }
}