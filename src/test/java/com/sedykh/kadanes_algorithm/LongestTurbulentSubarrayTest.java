package com.sedykh.kadanes_algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestTurbulentSubarrayTest {

    @Test
    void maxTurbulenceSize() {
        int actual = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{2, 3, 4, 5});
        assertEquals(2, actual);
    }

    @Test
    void maxTurbulenceSize2() {
        int actual = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{2});
        assertEquals(1, actual);
    }

    @Test
    void maxTurbulenceSize3() {
        int actual = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{2, 3, 2});
        assertEquals(3, actual);
    }

    @Test
    void maxTurbulenceSize4() {
        int actual = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        assertEquals(5, actual);
    }
}