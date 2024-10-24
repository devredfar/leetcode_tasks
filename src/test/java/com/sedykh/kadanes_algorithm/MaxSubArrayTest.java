package com.sedykh.kadanes_algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArrayTest {

    /**
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    @Test
    void maxSubArray() {
        int actual = new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, actual);
    }

    /**
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     */
    @Test
    void maxSubArray1() {
        int actual = new MaxSubArray().maxSubArray(new int[]{1});
        assertEquals(1, actual);
    }

    /**
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     */
    @Test
    void maxSubArray2() {
        int actual = new MaxSubArray().maxSubArray(new int[]{5, 4, -1, 7, 8});
        assertEquals(23, actual);
    }
}