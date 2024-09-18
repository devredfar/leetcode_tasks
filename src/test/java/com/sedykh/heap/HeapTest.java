package com.sedykh.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {

    @Test
    void test() {
        Heap heap = new Heap(100);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);

        assertEquals(8, heap.pop());
        assertEquals(7, heap.pop());

        heap.add(7);

        assertEquals(7, heap.pop());
        assertEquals(6, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(4, heap.pop());
        heap.add(10);
        heap.add(9);
        assertEquals(10, heap.pop());
        assertEquals(9, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(1, heap.pop());
    }
}