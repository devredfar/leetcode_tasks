package com.sedykh.prefix_sum;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQueryImmutable {

    public static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return prefixSum[right];
            }
            return prefixSum[right] - prefixSum[left-1];
        }

    }

    //Input
    //["NumArray", "sumRange", "sumRange", "sumRange"]
    //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    //Output
    //[null, 1, -1, -3]
    //-2, 0, 3
    //

//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
// -2, 0, 3, -5, 2, -1
// -2,-2, 1, -4,-2, -3
}
