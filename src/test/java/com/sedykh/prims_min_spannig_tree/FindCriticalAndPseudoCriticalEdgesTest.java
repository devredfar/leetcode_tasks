package com.sedykh.prims_min_spannig_tree;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FindCriticalAndPseudoCriticalEdgesTest {

    @Nested
    class MySolution {

        /**
         * Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]] Output: [[0,1],[2,3,4,5]]
         * Explanation: The figure above describes the graph.
         */
        @Test
        void findCriticalAndPseudoCriticalEdges1() {
            //given
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]");
            var expected = TestUtils.parseToList("[[0,1],[2,3,4,5]]");
            //when
            List<List<Integer>> actual = new FindCriticalAndPseudoCriticalEdges.MySolution().findCriticalAndPseudoCriticalEdges(5, edges);
            //then
            TestUtils.equalsInAnyOrder(actual, expected);
        }


        /**
         * Input: n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]] Output: [[],[0,1,2,3]] Explanation: We can observe
         * that since all 4 edges have equal weight, choosing any 3 edges from the given 4 will yield an MST. Therefore
         * all 4 edges are pseudo-critical.
         */
        @Test
        void findCriticalAndPseudoCriticalEdges2() {
            //given
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1,1],[1,2,1],[2,3,1],[0,3,1]]");
            var expected = TestUtils.parseToList("[[],[0,1,2,3]]");
            //when
            List<List<Integer>> actual = new FindCriticalAndPseudoCriticalEdges.MySolution().findCriticalAndPseudoCriticalEdges(5, edges);
            //then
            TestUtils.equalsInAnyOrder(actual, expected);
        }

        @Test
        void findCriticalAndPseudoCriticalEdges3() {
            //given
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]");
            var expected = TestUtils.parseToList("[[3],[0,1,2,4,5,6]]");
            //when
            List<List<Integer>> actual = new FindCriticalAndPseudoCriticalEdges.MySolution().findCriticalAndPseudoCriticalEdges(6, edges);
            //then
            TestUtils.equalsInAnyOrder(actual, expected);
        }

        @Test
        void findCriticalAndPseudoCriticalEdges4() {
            //given
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1,1],[0,2,2],[1,2,3]]");
            var expected = TestUtils.parseToList("[[0,1],[]]");
            //when
            List<List<Integer>> actual = new FindCriticalAndPseudoCriticalEdges.MySolution().findCriticalAndPseudoCriticalEdges(3, edges);
            //then
            TestUtils.equalsInAnyOrder(actual, expected);
        }

        @Test
        void findCriticalAndPseudoCriticalEdges5() {
            //given
            int[][] edges = TestUtils.parseToArray2dArray("[[0,1,13],[0,2,6],[2,3,13],[3,4,4],[0,5,11],[4,6,14],[4,7,8],[2,8,6],[4,9,6],[7,10,4],[5,11,3],[6,12,7],[12,13,9],[7,13,2],[5,13,10],[0,6,4],[2,7,3],[0,7,8],[1,12,9],[10,12,11],[1,2,7],[1,3,10],[3,10,6],[6,10,4],[4,8,5],[1,13,4],[11,13,8],[2,12,10],[5,8,1],[3,7,6],[7,12,12],[1,7,9],[5,9,1],[2,13,10],[10,11,4],[3,5,10],[6,11,14],[5,12,3],[0,8,13],[8,9,1],[3,6,8],[0,3,4],[2,9,6],[0,11,4],[2,5,14],[4,11,2],[7,11,11],[1,11,6],[2,10,12],[0,13,4],[3,9,9],[4,12,3],[6,7,10],[6,8,13],[9,11,3],[1,6,2],[2,4,12],[0,10,3],[3,12,1],[3,8,12],[1,8,6],[8,13,2],[10,13,12],[9,13,11],[2,11,14],[5,10,9],[5,6,10],[2,6,9],[4,10,7],[3,13,10],[4,13,3],[3,11,9],[7,9,14],[6,9,5],[1,5,12],[4,5,3],[11,12,3],[0,4,8],[5,7,8],[9,12,13],[8,12,12],[1,10,6],[1,9,9],[7,8,9],[9,10,13],[8,11,3],[6,13,7],[0,12,10],[1,4,8],[8,10,2]]");
            var expected = TestUtils.parseToList("[[13,16,45,55,57,58,61,89],[10,15,23,25,28,32,37,39,51,54,70,75,76,85]]");
            //when
            List<List<Integer>> actual = new FindCriticalAndPseudoCriticalEdges.MySolution().findCriticalAndPseudoCriticalEdges(14, edges);
            //then
            TestUtils.equalsInAnyOrder(actual, expected);
        }
    }
}