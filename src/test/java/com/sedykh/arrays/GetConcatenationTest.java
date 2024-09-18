package com.sedykh.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GetConcatenationTest {

    @Test
    void getConcatenation() {
        int[] actual = new GetConcatenation().getConcatenation(new int[]{1, 2, 1});
        assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, actual);
    }

    @Test
    void getConcatenation2() {
        int[] actual = new GetConcatenation().getConcatenation(new int[]{1, 3, 2, 1});
        assertArrayEquals(new int[]{1, 3, 2, 1, 1, 3, 2, 1}, actual);
    }
}