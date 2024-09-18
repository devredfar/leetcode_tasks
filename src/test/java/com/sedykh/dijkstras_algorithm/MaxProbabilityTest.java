package com.sedykh.dijkstras_algorithm;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MaxProbabilityTest {

    @Nested
    class MySolution {

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
         * <p>
         * Output: 0.25000
         * <p>
         * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other
         * has 0.5 * 0.5 = 0.25.
         */
        @Test
        void maxProbability_MySolution_1() {
            double actual = new MaxProbability.MySolution().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.2},
                0,
                2
            );
            Assertions.assertEquals(0.25000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
         * <p>
         * Output: 0.30000
         */
        @Test
        void maxProbability_MySolution_2() {
            double actual = new MaxProbability.MySolution().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.3},
                0,
                2
            );
            Assertions.assertEquals(0.30000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
         * <p>
         * Output: 0.00000
         * <p>
         * Explanation: There is no path between 0 and 2.
         */
        @Test
        void maxProbability_MySolution_3() {
            double actual = new MaxProbability.MySolution().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1]]"),
                new double[]{0.5},
                0,
                2
            );
            Assertions.assertEquals(0.00000, actual);
        }

        @Test
        void maxProbability_MySolution_4() {
            double actual = new MaxProbability.MySolution().maxProbability(
                10,
                TestUtils.parseToArray2dArray("[[0,3],[1,7],[1,2],[0,9]]"),
                new double[]{0.31, 0.9, 0.86, 0.36},
                2,
                3
            );
            Assertions.assertEquals(0.00000, actual);
        }
    }

    @Nested
    class MySolutionOptimized {

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
         * <p>
         * Output: 0.25000
         * <p>
         * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other
         * has 0.5 * 0.5 = 0.25.
         */
        @Test
        void maxProbability_MySolutionOptimized_1() {
            double actual = new MaxProbability.MySolutionOptimized().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.2},
                0,
                2
            );
            Assertions.assertEquals(0.25000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
         * <p>
         * Output: 0.30000
         */
        @Test
        void maxProbability_MySolutionOptimized_2() {
            double actual = new MaxProbability.MySolutionOptimized().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.3},
                0,
                2
            );
            Assertions.assertEquals(0.30000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
         * <p>
         * Output: 0.00000
         * <p>
         * Explanation: There is no path between 0 and 2.
         */
        @Test
        void maxProbability_MySolutionOptimized_3() {
            double actual = new MaxProbability.MySolutionOptimized().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1]]"),
                new double[]{0.5},
                0,
                2
            );
            Assertions.assertEquals(0.00000, actual);
        }

        @Test
        void maxProbability_MySolutionOptimized_4() {
            double actual = new MaxProbability.MySolutionOptimized().maxProbability(
                10,
                TestUtils.parseToArray2dArray("[[0,3],[1,7],[1,2],[0,9]]"),
                new double[]{0.31, 0.9, 0.86, 0.36},
                2,
                3
            );
            Assertions.assertEquals(0.00000, actual);
        }
    }

    @Nested
    class Optimal {

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
         * <p>
         * Output: 0.25000
         * <p>
         * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other
         * has 0.5 * 0.5 = 0.25.
         */
        @Test
        void maxProbability_Optimal_1() {
            double actual = new MaxProbability.Optimal().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.2},
                0,
                2
            );
            Assertions.assertEquals(0.25000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
         * <p>
         * Output: 0.30000
         */
        @Test
        void maxProbability_Optimal_2() {
            double actual = new MaxProbability.Optimal().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1],[1,2],[0,2]]"),
                new double[]{0.5, 0.5, 0.3},
                0,
                2
            );
            Assertions.assertEquals(0.30000, actual);
        }

        /**
         * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
         * <p>
         * Output: 0.00000
         * <p>
         * Explanation: There is no path between 0 and 2.
         */
        @Test
        void maxProbability_Optimal_3() {
            double actual = new MaxProbability.Optimal().maxProbability(
                3,
                TestUtils.parseToArray2dArray("[[0,1]]"),
                new double[]{0.5},
                0,
                2
            );
            Assertions.assertEquals(0.00000, actual);
        }

        @Test
        void maxProbability_Optimal_4() {
            double actual = new MaxProbability.Optimal().maxProbability(
                10,
                TestUtils.parseToArray2dArray("[[0,3],[1,7],[1,2],[0,9]]"),
                new double[]{0.31, 0.9, 0.86, 0.36},
                2,
                3
            );
            Assertions.assertEquals(0.00000, actual);
        }
    }
}