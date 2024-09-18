package com.sedykh.dijkstras_algorithm;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NetworkDelayTimeTest {

    @Test
    void networkDelayTime() {
        int[][] params = TestUtils.parseToArray2dArray("[[2,1,1],[2,3,1],[3,4,1]]");
        int actual = new NetworkDelayTime().networkDelayTime(params, 4, 2);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void networkDelayTime2() {
        int[][] params = TestUtils.parseToArray2dArray("[[1,2,1]]");
        int actual = new NetworkDelayTime().networkDelayTime(params, 2, 1);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void networkDelayTime3() {
        int[][] params = TestUtils.parseToArray2dArray("[[1,2,1]]");
        int actual = new NetworkDelayTime().networkDelayTime(params, 2, 2);
        Assertions.assertEquals(-1, actual);
    }
}