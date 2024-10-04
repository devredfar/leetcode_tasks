package com.sedykh.intervals;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxEventsTest {

    /**
     * Input: events = [[1,2],[2,3],[3,4]]
     * Output: 3
     * Explanation: You can attend all the three events.
     * One way to attend them all is as shown.
     * Attend the first event on day 1.
     * Attend the second event on day 2.
     * Attend the third event on day 3.
     */
    @Test
    public void test1() {
        int[][] events = TestUtils.parseToArray2dArray("[[1,2],[2,3],[3,4]]");
        int actual = new MaxEvents().maxEvents(events);
        Assertions.assertEquals(3, actual);
    }

    /**
     * Input: events= [[1,2],[2,3],[3,4],[1,2]]
     * Output: 4
     */
    @Test
    public void test2() {
        int[][] events = TestUtils.parseToArray2dArray("[[1,2],[2,3],[3,4],[1,2]]");
        int actual = new MaxEvents().maxEvents(events);
        Assertions.assertEquals(4, actual);
    }
}