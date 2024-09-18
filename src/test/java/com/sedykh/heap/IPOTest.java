package com.sedykh.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IPOTest {

    @Test
    void findMaximizedCapital() {
        int maximizedCapital = new IPO().findMaximizedCapital(2, 0, new int[]{1, 2, 3},
                new int[]{0, 1, 1});
        assertEquals(4, maximizedCapital);
    }

    @Test
    void findMaximizedCapital2() {
        int maximizedCapital = new IPO().findMaximizedCapital(11, 11, new int[]{1, 2, 3},
                new int[]{11, 12, 13});
        assertEquals(17, maximizedCapital);
    }
}