package com.sedykh.bits_manipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HammingWeightTest {

    @Test
    void hammingWeight_Optimal() {
        int actualResult = new HammingWeight.Optimal().hammingWeight(11);
        assertEquals(3, actualResult);
    }

    @Test
    void hammingWeight_SubOptimal() {
        int actualResult = new HammingWeight.SubOptimal().hammingWeight(11);
        assertEquals(3, actualResult);
    }

    @Test
    void hammingWeight_NiceWay() {
        int actualResult = new HammingWeight.NiceWay().hammingWeight(11);
        assertEquals(3, actualResult);
    }
}