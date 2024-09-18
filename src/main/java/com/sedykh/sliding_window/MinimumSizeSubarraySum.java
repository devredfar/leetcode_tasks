package com.sedykh.sliding_window;

/**
 * 209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum = sum + nums[r];
            while (sum >= target) {
                result = Math.min(result, r - l + 1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}