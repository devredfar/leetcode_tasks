package com.sedykh.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstUniqCharTest {

    @Test
    void firstUniqChar1() {
        int actual = new FirstUniqChar().firstUniqChar("leetcode");
        Assertions.assertEquals(actual, 0);
    }

    @Test
    void firstUniqChar2() {
        int actual = new FirstUniqChar().firstUniqChar("loveleetcode");
        Assertions.assertEquals(actual, 2);
    }

    @Test
    void firstUniqChar3() {
        int actual = new FirstUniqChar().firstUniqChar("aabb");
        Assertions.assertEquals(actual, -1);
    }
}