package com.sedykh.sliding_window;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayIITest {

    @Test
    void removeDuplicates() {
        int actual = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        assertEquals(5,actual);
    }
}