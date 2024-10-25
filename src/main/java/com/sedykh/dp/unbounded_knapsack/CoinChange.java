package com.sedykh.dp.unbounded_knapsack;

import java.util.Arrays;

/**
 * 322. Coin Change
 * <p>
 * You are given an integer array coins representing coins of different denominations and an
 * integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public static class Recursive {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int result = helperFunc(0, coins, 0, amount);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private int helperFunc(int i, int[] coins, int coinsUsed, int remaining) {
            if (remaining == 0) {
                return 0;
            }
            if (i == coins.length || remaining < 0) {
                return Integer.MAX_VALUE;
            }
            int withoutCoin = helperFunc(i + 1, coins, coinsUsed, remaining);
            int withCoin = Integer.MAX_VALUE;
            if (remaining >= coins[i]) {
                int res = helperFunc(i, coins, coinsUsed + 1, remaining - coins[i]);
                if (res != Integer.MAX_VALUE) {
                    withCoin = res + 1;
                }
            }
            return Math.min(withoutCoin, withCoin);
        }
    }

    public static class TwoDP {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[][] cache = new int[coins.length + 1][amount + 1];
            for (int[] row : cache) {
                Arrays.fill(row, -1);
            }
            int result = helperFunc(0, coins, amount, cache);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private int helperFunc(int i, int[] coins, int remaining, int[][] cache) {
            if (remaining == 0) {
                return 0;
            }
            if (i == coins.length || remaining < 0) {
                return Integer.MAX_VALUE;
            }
            if (cache[i][remaining] != -1) {
                return cache[i][remaining];
            }

            int withoutCoin = helperFunc(i + 1, coins, remaining, cache);
            int withCoin = Integer.MAX_VALUE;
            if (remaining >= coins[i]) {
                int res = helperFunc(i, coins, remaining - coins[i], cache);
                if (res != Integer.MAX_VALUE) {
                    withCoin = res + 1;
                }
            }

            cache[i][remaining] = Math.min(withoutCoin, withCoin);
            return cache[i][remaining];
        }
    }

    public static class OneDP {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] cacheCointsCount = new int[amount + 1];
            Arrays.fill(cacheCointsCount, Integer.MAX_VALUE);
            cacheCointsCount[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    if (cacheCointsCount[i - coin] != Integer.MAX_VALUE) {
                        cacheCointsCount[i] = Math.min(cacheCointsCount[i], cacheCointsCount[i - coin] + 1);
                    }
                }
            }

            return cacheCointsCount[amount] == Integer.MAX_VALUE ? -1 : cacheCointsCount[amount];
        }
    }
}