package com.sedykh.dp.unbounded_knapsack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProfitTest {

    @Nested
    class Recursive {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 18
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.Recursive().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            assertEquals(18, actual);
        }
    }

    @Nested
    class TwoDP {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 18
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.TwoDP().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            assertEquals(18, actual);
        }
    }

    @Nested
    class OneDP {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 18
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.OneDP().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            assertEquals(18, actual);
        }
    }

}