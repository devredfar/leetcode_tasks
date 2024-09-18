package com.sedykh.sliding_window;

/***
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int highestPrice = Integer.MIN_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price > highestPrice) {
                highestPrice = price;
                profit  = Math.max(profit , highestPrice - lowestPrice);
            }
            if (price < lowestPrice) {
                lowestPrice = price;
                highestPrice = price;
            }
        }
        return profit;
    }
}
