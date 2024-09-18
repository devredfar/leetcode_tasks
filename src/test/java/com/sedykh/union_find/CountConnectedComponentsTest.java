package com.sedykh.union_find;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountConnectedComponentsTest {

    @Test
    void countComponents() {
        int result = new CountConnectedComponents().countComponents(3, new int[][]{{0, 1}, {0, 2}});
        assertEquals(1, result);
    }
}