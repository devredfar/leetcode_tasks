package com.sedykh.bits_manipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountBitsTest {

    @Test
    void countBits_Naive_1() {
        int[] actual = new CountBits.Naive().countBits(2);
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, actual);
    }

    @Test
    void countBits_Naive_2() {
        int[] actual = new CountBits.Naive().countBits(5);
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, actual);
    }

    @Test
    void countBits_Optimal_1() {
        int[] actual = new CountBits.Optimal().countBits(2);
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, actual);
    }

    @Test
    void countBits_Optimal_2() {
        int[] actual = new CountBits.Optimal().countBits(5);
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, actual);
    }
}