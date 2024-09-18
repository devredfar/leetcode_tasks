package com.sedykh.prefix_sum;

/**
 * ]
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>
 * The pivot index is the index where the sum of all the numbers strictly to the left
 * of the index is equal to the sum of all the numbers strictly to the index's right.
 * <p>
 * If the index is on the left edge of the array, then the left sum is 0
 * because there are no elements to the left. This also applies to the right edge of the array.
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int lastElem = nums.length - 1;
        postfixSum[lastElem] = nums[lastElem];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            postfixSum[lastElem - i] = postfixSum[lastElem - i + 1] + nums[lastElem - i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (postfixSum[i] == prefixSum[i]) {
                return i;
            }
        }
        return -1;
    }
}

