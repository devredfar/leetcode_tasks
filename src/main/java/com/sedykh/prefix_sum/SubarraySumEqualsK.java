package com.sedykh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        var sum = 0;
        for (int num : nums) {
            sum = num + sum;
            int diff = sum - k;
            if (prefixSumCount.containsKey(diff)) {
                result += prefixSumCount.get(diff);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}