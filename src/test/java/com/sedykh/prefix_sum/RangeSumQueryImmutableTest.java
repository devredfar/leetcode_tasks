package com.sedykh.prefix_sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumQueryImmutableTest {

    @Test
    public void test() {
        RangeSumQueryImmutable.NumArray numArray = new RangeSumQueryImmutable.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, numArray.sumRange(0,2));
    }

    @Test
    public void test2() {
        RangeSumQueryImmutable.NumArray numArray = new RangeSumQueryImmutable.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(-1, numArray.sumRange(2,5));
    }

    @Test
    public void test3() {
        RangeSumQueryImmutable.NumArray numArray = new RangeSumQueryImmutable.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(-3, numArray.sumRange(0,5));
    }

}