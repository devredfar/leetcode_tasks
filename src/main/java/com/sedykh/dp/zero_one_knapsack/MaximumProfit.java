package com.sedykh.dp.zero_one_knapsack;

import java.util.Arrays;
import java.util.List;

/**
 * 0 / 1 Knapsack
 * <p>
 * Solve the 0 / 1 Knapsack problem.
 * <p>
 * You are given a list of items, each with a weight and a profit, along with a backpack with a specified
 * maximum capacity. Your goal is to calculate the maximum profit you can achieve without exceeding the backpack's capacity.
 * You must select items such that the total weight of the items is less than or equal to the backpack's capacity. You can select at most one of each item.
 * <p>
 * Input:
 * profit - a list of n integers, where profit[i] represents the profit of the i-th item. (1 <= profit[i] <= 100)
 * weight - a list of n integers, where weight[i] represents the weight of the i-th item. (1 <= weight[i] <= 100)
 * capacity - an integer representing the maximum weight the backpack can hold. (1 <= capacity <= 100)
 * Here, n is the number of items, where 1 <= n <= 100. You can assume that weight and profit are both the same length and only contain positive integers.
 */
public class MaximumProfit {

    public static class Recursive {
        public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
            return helperFunc(0, profit, weight, capacity);
        }

        private int helperFunc(int i, List<Integer> profits, List<Integer> weights, int capacity) {
            if (i >= profits.size()) {
                return 0;
            }
            int maxProfit = helperFunc(i + 1, profits, weights, capacity);
            int newCapacity = capacity - weights.get(i);
            if (newCapacity >= 0) {
                int profit = profits.get(i) + helperFunc(i + 1, profits, weights, newCapacity);
                maxProfit = Math.max(maxProfit, profit);
            }
            return maxProfit;
        }
    }

    public static class Memorization {
        public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
            int[][] cache = new int[profit.size()][capacity + 1];
            for (int[] rows : cache) {
                Arrays.fill(rows, -1);
            }
            return helperFunc(0, profit, weight, capacity, cache);
        }

        private int helperFunc(int i, List<Integer> profits, List<Integer> weights, int capacity, int[][] cache) {
            if (i >= profits.size()) {
                return 0;
            }
            if (cache[i][capacity] != -1) {
                return cache[i][capacity];
            }
            cache[i][capacity] = helperFunc(i + 1, profits, weights, capacity, cache);
            int newCapacity = capacity - weights.get(i);
            if (newCapacity >= 0) {
                int profit = profits.get(i) + helperFunc(i + 1, profits, weights, newCapacity, cache);
                cache[i][capacity] = Math.max(cache[i][capacity], profit);
            }
            return cache[i][capacity];
        }
    }

    public static class OptimizedMemorization {
        public int maximumProfit(List<Integer> profits, List<Integer> weights, int maxCapacity) {
            int itemCount = profits.size();
            int[] profitCache = new int[maxCapacity + 1]; // Array to store max profit for each capacity

            // Initialize profitCache array for the first item
            for (int capacity = 0; capacity <= maxCapacity; capacity++) {
                if (weights.get(0) <= capacity) {
                    profitCache[capacity] = profits.get(0);
                }
            }

            // Process each item and calculate the max profit at each capacity level
            for (int itemIndex = 1; itemIndex < itemCount; itemIndex++) {
                // Traverse capacities in reverse to prevent overwriting values prematurely
                for (int capacity = maxCapacity; capacity >= weights.get(itemIndex); capacity--) {
                    // Calculate profit if including the current item
                    int profitWithItem = profits.get(itemIndex) + profitCache[capacity - weights.get(itemIndex)];
                    // Update profitCache array with the maximum of including or excluding the item
                    profitCache[capacity] = Math.max(profitCache[capacity], profitWithItem);
                }
            }

            // Maximum profit for the given capacity
            return profitCache[maxCapacity];
        }
    }
}
