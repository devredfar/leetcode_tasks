package com.sedykh.topological_sort;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SortItemsTest {

    @Nested
    class Internet {
        /**
         * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]] Output:
         * [6,3,4,1,5,2,0,7]
         */
        @Test
        public void test() {
            ArrayList<List<Integer>> beforeItems = TestUtils.parseToList("[[],[6],[5],[6],[3,6],[],[],[]]");
            int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
            int[] actual = new SortItems.Internet().sortItems(8, 2, group, beforeItems);
            Assertions.assertArrayEquals(new int[]{6, 3, 4, 1, 5, 2, 0, 7}, actual);
        }

        /**
         * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]] Output: []
         * Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
         */
        @Test
        public void test2() {
            ArrayList<List<Integer>> beforeItems = TestUtils.parseToList("[[],[6],[5],[6],[3],[],[4],[]]");
            int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
            int[] actual = new SortItems.Internet().sortItems(8, 2, group, beforeItems);
            Assertions.assertArrayEquals(new int[0], actual);
        }
    }

    @Nested
    class MySolution {
        /**
         * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]] Output:
         * [6,3,4,1,5,2,0,7]
         */
        @Test
        public void test() {
            ArrayList<List<Integer>> beforeItems = TestUtils.parseToList("[[],[6],[5],[6],[3,6],[],[],[]]");
            int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
            int[] actual = new SortItems.MySolution().sortItems(8, 2, group, beforeItems);
            Assertions.assertArrayEquals(new int[]{6, 3, 4, 1, 5, 2, 0, 7}, actual);
        }

        /**
         * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]] Output: []
         * Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
         */
        @Test
        public void test2() {
            ArrayList<List<Integer>> beforeItems = TestUtils.parseToList("[[],[6],[5],[6],[3],[],[4],[]]");
            int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
            int[] actual = new SortItems.MySolution().sortItems(8, 2, group, beforeItems);
            Assertions.assertArrayEquals(new int[0], actual);
        }
    }

}