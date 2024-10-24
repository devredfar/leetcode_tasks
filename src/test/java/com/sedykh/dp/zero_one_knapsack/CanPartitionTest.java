package com.sedykh.dp.zero_one_knapsack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanPartitionTest {

    @Nested
    class Recursive {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.Recursive().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.Recursive().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.Recursive().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.Recursive().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.Recursive().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }
    }

    @Nested
    class MemorizationWithRecursion {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.MemorizationWithRecursion().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.MemorizationWithRecursion().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.MemorizationWithRecursion().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.MemorizationWithRecursion().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.MemorizationWithRecursion().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }
    }

    @Nested
    class NeetcodeMemorization {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.NeetcodeMemorization().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.NeetcodeMemorization().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.NeetcodeMemorization().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.NeetcodeMemorization().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.NeetcodeMemorization().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }
    }

    @Nested
    class SimplifiedNeetcodeMemorization {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.SimplifiedNeetcodeMemorization().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.SimplifiedNeetcodeMemorization().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.SimplifiedNeetcodeMemorization().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.SimplifiedNeetcodeMemorization().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.SimplifiedNeetcodeMemorization().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }
    }

    @Nested
    class DP {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.DP().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.DP().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.DP().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.DP().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.DP().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }

        @Test
        void canPartition6() {
            boolean actual = new CanPartition.DP().canPartition(new int[]{1, 2, 5});
            assertFalse(actual);
        }
    }

    @Nested
    class DPOptimized {
        /**
         * Input: nums = [1,5,11,5]
         * Output: true
         * Explanation: The array can be partitioned as [1, 5, 5] and [11].
         */
        @Test
        void canPartition() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[]{1, 5, 11, 5});
            assertTrue(actual);
        }

        /**
         * Input: nums = [1,2,3,5]
         * Output: false
         * Explanation: The array cannot be partitioned into equal sum subsets.
         */
        @Test
        void canPartition2() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[]{1, 2, 3, 5});
            assertFalse(actual);
        }

        @Test
        void canPartition3() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[]{1});
            assertFalse(actual);
        }

        @Test
        void canPartition4() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[0]);
            assertFalse(actual);
        }

        @Test
        void canPartition5() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[]{1, 2, 3});
            assertTrue(actual);
        }

        @Test
        void canPartition6() {
            boolean actual = new CanPartition.DPOptimized().canPartition(new int[]{1, 2, 5});
            assertFalse(actual);
        }
    }
}