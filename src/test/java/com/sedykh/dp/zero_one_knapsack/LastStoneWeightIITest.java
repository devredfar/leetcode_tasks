package com.sedykh.dp.zero_one_knapsack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightIITest {

    @Nested
    class TwoDP {
        /**
         * Input: stones = [2,7,4,1,8,1]
         * Output: 1
         * Explanation:
         * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
         * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
         * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
         * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
         */
        @Test
        void lastStoneWeightII() {
            int actual = new LastStoneWeightII.TwoDP().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
            assertEquals(1, actual);
        }

        /**
         * Input: stones = [31,26,33,21,40]
         * Output: 5
         */
        @Test
        void lastStoneWeightII_2() {
            int actual = new LastStoneWeightII.TwoDP().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
            assertEquals(5, actual);
        }
    }

    @Nested
    class TwoDPLeetcode {
        /**
         * Input: stones = [2,7,4,1,8,1]
         * Output: 1
         * Explanation:
         * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
         * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
         * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
         * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
         */
        @Test
        void lastStoneWeightII() {
            int actual = new LastStoneWeightII.TwoDPLeetcode().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
            assertEquals(1, actual);
        }

        /**
         * Input: stones = [31,26,33,21,40]
         * Output: 5
         */
        @Test
        void lastStoneWeightII_2() {
            int actual = new LastStoneWeightII.TwoDPLeetcode().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
            assertEquals(5, actual);
        }
    }

    @Nested
    class OneDPLeetcode {
        /**
         * Input: stones = [2,7,4,1,8,1]
         * Output: 1
         * Explanation:
         * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
         * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
         * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
         * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
         */
        @Test
        void lastStoneWeightII() {
            int actual = new LastStoneWeightII.OneDPLeetcode().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
            assertEquals(1, actual);
        }

        /**
         * Input: stones = [31,26,33,21,40]
         * Output: 5
         */
        @Test
        void lastStoneWeightII_2() {
            int actual = new LastStoneWeightII.OneDPLeetcode().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
            assertEquals(5, actual);
        }
    }

}