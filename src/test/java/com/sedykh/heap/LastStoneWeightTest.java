package com.sedykh.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightTest {

    @Test
    void lastStoneWeight() {
        int result = new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        assertEquals(1, result);
    }
}