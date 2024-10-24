package com.sedykh.dp.zero_one_knapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaximumProfitTest {

    @Nested
    class Recursive {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 12
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.Recursive().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            Assertions.assertEquals(12, actual);
        }

        /**
         * profit=[60,100,120]
         * weight=[10,20,30]
         * capacity=50
         */
        @Test
        void maximumProfit2() {
            int actual = new MaximumProfit.Recursive().maximumProfit(List.of(60, 100, 120), List.of(10, 20, 30), 50);
            Assertions.assertEquals(220, actual);
        }
    }

    @Nested
    class Memorization {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 12
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.Memorization().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            Assertions.assertEquals(12, actual);
        }

        /**
         * profit=[60,100,120]
         * weight=[10,20,30]
         * capacity=50
         */
        @Test
        void maximumProfit2() {
            int actual = new MaximumProfit.Memorization().maximumProfit(List.of(60, 100, 120), List.of(10, 20, 30), 50);
            Assertions.assertEquals(220, actual);
        }
    }

    @Nested
    class OptimizedMemorization {
        /**
         * Input:
         * profit = [4, 4, 7, 1]
         * weight = [5, 2, 3, 1]
         * capacity = 8
         * Output:
         * 12
         */
        @Test
        void maximumProfit() {
            int actual = new MaximumProfit.OptimizedMemorization().maximumProfit(List.of(4, 4, 7, 1), List.of(5, 2, 3, 1), 8);
            Assertions.assertEquals(12, actual);
        }

        /**
         * profit=[60,100,120]
         * weight=[10,20,30]
         * capacity=50
         */
        @Test
        void maximumProfit2() {
            int actual = new MaximumProfit.OptimizedMemorization().maximumProfit(List.of(60, 100, 120), List.of(10, 20, 30), 50);
            Assertions.assertEquals(220, actual);
        }
    }

}