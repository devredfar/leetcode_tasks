package com.sedykh.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SlidingWindowMedianTest {

    @Nested
    class Optimal {

        /**
         * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
         */
        @Test
        void medianSlidingWindow() {
            double[] actual = new SlidingWindowMedian.OptimalSolution()
                .medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
            Assertions.assertArrayEquals(new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000}, actual);
        }

        /**
         * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
         * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
         */
        @Test
        void medianSlidingWindow2() {
            double[] actual = new SlidingWindowMedian.OptimalSolution()
                .medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3);
            Assertions.assertArrayEquals(new double[]{2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000}, actual);
        }
    }

    @Nested
    class MySolution {

        /**
         * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
         */
        @Test
        void medianSlidingWindow() {
            double[] actual = new SlidingWindowMedian.MySolution()
                .medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
            Assertions.assertArrayEquals(new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000}, actual);
        }

        /**
         * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3 Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
         */
        @Test
        void medianSlidingWindow2() {
            double[] actual = new SlidingWindowMedian.MySolution()
                .medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3);
            Assertions.assertArrayEquals(new double[]{2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000}, actual);
        }
    }

}