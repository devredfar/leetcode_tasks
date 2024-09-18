package com.sedykh.prefix_sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumQuery2DImmutableTest {

    @Test
    public void test(){
        RangeSumQuery2DImmutable.NumMatrix matrix = new RangeSumQuery2DImmutable.NumMatrix(
                new int[][]{{1,1,1}, {1,1,1}, {1,1,1}});
        int sum = matrix.sumRegion(0, 0, 2, 2);
        assertEquals(9, sum);
    }

    @Test
    public void test2(){
        RangeSumQuery2DImmutable.NumMatrix matrix = new RangeSumQuery2DImmutable.NumMatrix(
                new int[][]{{1,1,1}, {1,1,1}, {1,1,1}});
        int sum = matrix.sumRegion(1, 1, 2, 2);
        assertEquals(4, sum);
    }

    @Test
    public void test3(){
        RangeSumQuery2DImmutable.NumMatrix matrix = new RangeSumQuery2DImmutable.NumMatrix(
                new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}});
        int sum = matrix.sumRegion(2, 2, 3, 3);
        assertEquals(4, sum);
    }
}