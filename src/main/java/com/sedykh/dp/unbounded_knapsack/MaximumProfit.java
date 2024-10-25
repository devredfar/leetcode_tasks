package com.sedykh.dp.unbounded_knapsack;

import java.util.Arrays;
import java.util.List;

/**
 * Unbounded Knapsack
 * Solve the Unbounded Knapsack problem.
 * You are given a list of items, each with a weight and a profit, along with a backpack with
 * a specified maximum capacity.
 * Your goal is to calculate the maximum profit you can achieve without exceeding the backpack's capacity.
 * You must select items such that the total weight of the items is less than or equal to the backpack's capacity.
 * Assume you can select each item up to an unlimited number of times.
 */
public class MaximumProfit {

    /**
     * Time: O(2^n), Space: O(n)
     */
    public static class Recursive {
        public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
            return helperFunc(0, profit, weight, 0, capacity);
        }

        private int helperFunc(int i, List<Integer> profit, List<Integer> weight, int accProfit, int capacity) {
            if (i >= profit.size()) {
                return accProfit;
            }
            if (capacity < 0) {
                return accProfit;
            }
            var accProfitNotInclude = helperFunc(i + 1, profit, weight, accProfit, capacity);
            int newCapacity = capacity - weight.get(i);
            int accProfitIncludeSame = 0;
            int accProfitIncludeNext = 0;
            if (newCapacity >= 0) {
                accProfitIncludeSame = helperFunc(i, profit, weight, accProfit + profit.get(i), newCapacity);
                accProfitIncludeNext = helperFunc(i + 1, profit, weight, accProfit + profit.get(i), newCapacity);
            }
            return Math.max(accProfitIncludeSame, Math.max(accProfitIncludeNext, accProfitNotInclude));
        }
    }

    /**
     * Time Complexity: O(n * capacity), where n is the number of items and capacity is the knapsack capacity.
     * Space Complexity: O(n * capacity)
     */
    public static class TwoDP {
        public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
            int[][] cache = new int[profit.size()][capacity + 1];
            for (int[] rows : cache) {
                Arrays.fill(rows, -1);
            }
            return helperFunc(0, profit, weight, 0, capacity, cache);
        }

        private int helperFunc(int i, List<Integer> profit, List<Integer> weight, int accProfit, int capacity, int[][] cache) {
            if (i >= profit.size()) {
                return accProfit;
            }

            if (cache[i][capacity] != -1) {
                if (cache[i][capacity] > accProfit) {
                    return cache[i][capacity];
                } else {
                    cache[i][capacity] = accProfit;
                }
            }

            cache[i][capacity] = helperFunc(i + 1, profit, weight, accProfit, capacity, cache);
            int newCapacity = capacity - weight.get(i);
            int accProfitIncludeSame = 0;
            int accProfitIncludeNext = 0;
            if (newCapacity >= 0) {
                accProfitIncludeSame = helperFunc(i, profit, weight, accProfit + profit.get(i), newCapacity, cache);
                accProfitIncludeNext = helperFunc(i + 1, profit, weight, accProfit + profit.get(i), newCapacity, cache);
            }
            return Math.max(accProfitIncludeSame, Math.max(accProfitIncludeNext, cache[i][capacity]));
        }
    }

    // Time: O(n * m), Space: O(m)
    public static class OneDP {
        public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
            Integer[] profitCache = new Integer[capacity + 1];
            Arrays.fill(profitCache, 0);

            for (int rockIndex = 0; rockIndex < weight.size(); rockIndex++) {
                Integer[] updatedProfitCache = new Integer[capacity + 1];
                Arrays.fill(updatedProfitCache, 0);
                for (int currentCapacity = 1; currentCapacity <= capacity; currentCapacity++) {
                    int cachedProfitForCapacity = profitCache[currentCapacity];
                    int newProfitIfInclude = 0;
                    Integer rockWeight = weight.get(rockIndex);
                    int currentCapacityWithoutRock = currentCapacity - rockWeight;
                    if (currentCapacityWithoutRock >= 0) {
                        Integer rockProfit = profit.get(rockIndex);
                        newProfitIfInclude = rockProfit + updatedProfitCache[currentCapacityWithoutRock];
                    }
                    updatedProfitCache[currentCapacity] = Math.max(newProfitIfInclude, cachedProfitForCapacity);
                }
                profitCache = updatedProfitCache;
            }
            return profitCache[capacity];
        }
    }
}
