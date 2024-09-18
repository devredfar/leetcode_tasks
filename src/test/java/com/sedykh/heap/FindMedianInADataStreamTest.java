package com.sedykh.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianInADataStreamTest {

    /**
     * Input ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"] [[], [1], [2], [], [3], []]
     * Output [null, null, null, 1.5, null, 2.0]
     */
    @Test
    public void test() {
        var medianFinder = new FindMedianInADataStream.MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        assertEquals(1.5, median);
        medianFinder.addNum(3);
        double median2 = medianFinder.findMedian();
        assertEquals(2, median2);
    }

}