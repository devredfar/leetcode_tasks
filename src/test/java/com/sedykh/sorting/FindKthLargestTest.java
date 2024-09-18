package com.sedykh.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKthLargestTest {

    @Test
    void findKthLargest() {
        var result = new FindKthLargest().findKthLargest(new int[]{2, 3, 1, 5, 6, 4, 7, 9, 10, 8}, 2);
        assertEquals(9, result);
    }

    @Test
    void findKthLargest2() {
        var result = new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        assertEquals(4, result);
    }
}