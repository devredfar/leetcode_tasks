package com.sedykh.dp.unbounded_knapsack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Nested
    class Recursive {
        /**
         * Input: coins = [1,2,5], amount = 11
         * Output: 3
         * Explanation: 11 = 5 + 5 + 1
         */
        @Test
        void coinChange() {
            int actual = new CoinChange.Recursive().coinChange(new int[]{1, 2, 5}, 11);
            assertEquals(3, actual);
        }

        /**
         * Input: coins = [2], amount = 3
         * Output: -1
         */
        @Test
        void coinChange2() {
            int actual = new CoinChange.Recursive().coinChange(new int[]{2}, 3);
            assertEquals(-1, actual);
        }

        /**
         * Input: coins = [1], amount = 0
         * Output: 0
         */
        @Test
        void coinChange3() {
            int actual = new CoinChange.Recursive().coinChange(new int[]{1}, 0);
            assertEquals(0, actual);
        }
    }

    @Nested
    class TwoDP {
        /**
         * Input: coins = [1,2,5], amount = 11
         * Output: 3
         * Explanation: 11 = 5 + 5 + 1
         */
        @Test
        void coinChange() {
            int actual = new CoinChange.TwoDP().coinChange(new int[]{1, 2, 5}, 11);
            assertEquals(3, actual);
        }

        /**
         * Input: coins = [2], amount = 3
         * Output: -1
         */
        @Test
        void coinChange2() {
            int actual = new CoinChange.TwoDP().coinChange(new int[]{2}, 3);
            assertEquals(-1, actual);
        }

        /**
         * Input: coins = [1], amount = 0
         * Output: 0
         */
        @Test
        void coinChange3() {
            int actual = new CoinChange.TwoDP().coinChange(new int[]{1}, 0);
            assertEquals(0, actual);
        }

        /**
         * coins=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * amount=100
         */
        @Test
        void coinChange4() {
            int actual = new CoinChange.TwoDP().coinChange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100);
            assertEquals(10, actual);
        }
    }

    @Nested
    class OneDP {
        /**
         * Input: coins = [1,2,5], amount = 11
         * Output: 3
         * Explanation: 11 = 5 + 5 + 1
         */
        @Test
        void coinChange() {
            int actual = new CoinChange.OneDP().coinChange(new int[]{1, 2, 5}, 11);
            assertEquals(3, actual);
        }

        /**
         * Input: coins = [2], amount = 3
         * Output: -1
         */
        @Test
        void coinChange2() {
            int actual = new CoinChange.OneDP().coinChange(new int[]{2}, 3);
            assertEquals(-1, actual);
        }

        /**
         * Input: coins = [1], amount = 0
         * Output: 0
         */
        @Test
        void coinChange3() {
            int actual = new CoinChange.OneDP().coinChange(new int[]{1}, 0);
            assertEquals(0, actual);
        }

        /**
         * coins=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * amount=100
         */
        @Test
        void coinChange4() {
            int actual = new CoinChange.OneDP().coinChange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100);
            assertEquals(10, actual);
        }
    }

}