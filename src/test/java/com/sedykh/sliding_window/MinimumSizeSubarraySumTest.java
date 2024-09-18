package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumSizeSubarraySumTest {

    @Test
    void minSubArrayLen() {
        int actual = new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assertions.assertEquals(2, actual);
    }

    @Test
    void minSubArrayLen2() {
        int actual = new MinimumSizeSubarraySum().minSubArrayLen(4, new int[]{1, 4, 4});
        Assertions.assertEquals(1, actual);
    }

    @Test
    void minSubArrayLen3() {
        int actual = new MinimumSizeSubarraySum().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        Assertions.assertEquals(0, actual);
    }
}