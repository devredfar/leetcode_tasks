package com.sedykh.kadanes_algorithm;

/**
 * 53. Maximum Subarray
 * <p>
 * Given an integer array nums, find the subarray
 *  with the largest sum, and return its sum.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i] + current, nums[i]);
            sum = Math.max(sum, current);
        }
        return sum;
    }
}