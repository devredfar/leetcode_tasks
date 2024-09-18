package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxProfitTest {

    @Test
    void maxProfit() {
        int actual = MaxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assertions.assertEquals(5, actual);
    }

    @Test
    void maxProfit2() {
        int actual = MaxProfit.maxProfit(new int[]{7,6,4,3,1});
        Assertions.assertEquals(0, actual);
    }
}