package com.sedykh.sliding_window;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsNearbyDuplicateTest {

    @Test
    void containsNearbyDuplicate() {
        boolean actual = new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 3, 2, 1, 0}, 2);
        assertFalse(actual);
    }

    @Test
    void containsNearbyDuplicate2() {
        boolean actual = new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 3, 2, 1, 0}, 3);
        assertTrue(actual);
    }
}