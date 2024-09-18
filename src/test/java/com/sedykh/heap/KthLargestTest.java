package com.sedykh.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestTest {

    /**
     * Input: ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * <p>
     * Output: [null, 4, 5, 5, 8, 8]
     */
    @Test
    void findKthLargest_MinHeap() {
        var kthLargest = new KthLargest.KthLargestWithMinHeap(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

    @Test
    void findKthLargest_PriorityQueue() {
        var kthLargest = new KthLargest.KthLargestWithPriorityQueue(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

}