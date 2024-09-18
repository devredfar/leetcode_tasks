package com.sedykh.kadanes_algorithm;

/**
 * Given a circular integer array nums of length n,
 * return the maximum possible sum of a non-empty subarray of nums.
 * <p>
 * A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element
 * of nums[i] is nums[(i - 1 + n) % n].
 * <p>
 * A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
 * there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0;
        int globMax = nums[0], globMin = nums[0];
        int total = 0;
        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            curMin = Math.min(curMin + n, n);
            total += n;
            globMax = Math.max(curMax, globMax);
            globMin = Math.min(curMin, globMin);
        }
        return globMax > 0 ? Math.max(globMax, total - globMin) : globMax;
    }
}
