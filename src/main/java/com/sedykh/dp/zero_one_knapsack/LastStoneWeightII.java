package com.sedykh.dp.zero_one_knapsack;

import java.util.Arrays;

/**
 * 1049. Last Stone Weight II
 * <p>
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
 * Suppose the stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * <p>
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 * <p>
 * Constraints:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class LastStoneWeightII {

    /**
     * Time complexity: O(n * sum/2)
     * Space complexity: O(n * sum/2)
     */
    public static class TwoDP {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int stone : stones) {
                sum += stone;
            }
            int target = sum / 2;
            int[][] cache = new int[stones.length + 1][target + 1];
            for (int[] arr : cache) Arrays.fill(arr, -1);
            int diff = helperFunc(0, stones, target, cache);
            return sum - 2 * diff;
        }

        private int helperFunc(int i, int[] stones, int target, int[][] cache) {
            if (i == stones.length - 1) {
                if (stones[i] <= target) {
                    return stones[i];
                }
                return 0;
            }
            if (cache[i][target] != -1) {
                return cache[i][target];
            }
            int notTake = helperFunc(i + 1, stones, target, cache);
            int take = Integer.MIN_VALUE;
            if (stones[i] <= target) {
                take = stones[i] + helperFunc(i + 1, stones, target - stones[i], cache);
            }
            return cache[i][target] = Math.max(notTake, take);

        }
    }

    public static class TwoDPLeetcode {
        public int lastStoneWeightII(int[] stones) {
            int totSum = 0;
            for (int x : stones) {
                totSum += x;
            }
            int[][] dp = new int[stones.length][totSum + 1];
            for (int[] arr : dp) Arrays.fill(arr, -1);
            int diff = recursion(0, stones, totSum / 2, dp);

            return totSum - 2 * diff;
        }

        public int recursion(int index, int[] stones, int W, int[][] dp) {
            if (index == stones.length - 1) {
                if (stones[index] <= W) return stones[index];
                else return 0;
            }
            if (dp[index][W] != -1) return dp[index][W];
            int notTake = recursion(index + 1, stones, W, dp);
            int take = Integer.MIN_VALUE;

            if (stones[index] <= W) {
                take = stones[index] + recursion(index + 1, stones, W - stones[index], dp);
            }

            return dp[index][W] = Math.max(notTake, take);
        }
    }

    /**
     * Time complexity: O(n * sum/2)
     * Space complexity: O(sum/2)
     */
    public static class OneDPLeetcode {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int stoneWeight : stones) sum += stoneWeight;

            int halfSum = sum / 2;
            boolean[] sumCache = new boolean[halfSum + 1];
            sumCache[0] = true;

            for (int stoneWeight : stones) {
                for (int currentSum = halfSum; currentSum >= stoneWeight; currentSum--) {
                    if (sumCache[currentSum - stoneWeight]) {
                        sumCache[currentSum] = true;
                        max = Math.max(max, currentSum);
                        if (currentSum == halfSum) return sum - max * 2;
                    }
                }
            }
            // diff = group 2 sum - group 1 sum
            // group 2 sum = total - group 1 sum
            // diff = total - group 1 sum - group 1 sum
            // diff = total - 2 * group 1 sum
            return sum - max * 2;
        }
    }

}
