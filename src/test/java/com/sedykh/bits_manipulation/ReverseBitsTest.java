package com.sedykh.bits_manipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseBitsTest {

    @Test
    void reverseBits() {
        int actual = new ReverseBits().reverseBits(-3);
        assertEquals(-1073741825, actual);
    }
}