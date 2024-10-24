package com.sedykh.kadanes_algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarraySumCircularTest {

    /**
     * Input: nums = [1,-2,3,-2]
     * Output: 3
     * Explanation: Subarray [3] has maximum sum 3.
     */
    @Test
    void maxSubarraySumCircular() {
        int actual = new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{1, -2, 3, -2});
        assertEquals(3, actual);
    }

    /**
     * Input: nums = [5,-3,5]
     * Output: 10
     * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
     */
    @Test
    void maxSubarraySumCircular2() {
        int actual = new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{5, -3, 5});
        assertEquals(10, actual);
    }

    /**
     * Input: nums = [-3,-2,-3]
     * Output: -2
     * Explanation: Subarray [-2] has maximum sum -2.
     */
    @Test
    void maxSubarraySumCircular3() {
        int actual = new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{-3, -2, -3});
        assertEquals(-2, actual);
    }
}