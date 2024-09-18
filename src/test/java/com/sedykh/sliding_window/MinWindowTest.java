package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinWindowTest {

    @Test
    void minWindow1() {
        String actual = new MinWindow.MySolution().minWindow("ADOBECODEBANC", "ABC");
        Assertions.assertEquals("BANC", actual);
    }

    @Test
    void minWindow2() {
        String actual = new MinWindow.MySolution().minWindow("a", "a");
        Assertions.assertEquals("a", actual);
    }

    @Test
    void minWindow3() {
        String actual = new MinWindow.MySolution().minWindow("a", "aaa");
        Assertions.assertEquals("", actual);
    }

    @Test
    void minWindow4() {
        String actual = new MinWindow.MySolution().minWindow("aaaa", "aaaa");
        Assertions.assertEquals("aaaa", actual);
    }

    @Test
    void minWindow5() {
        String actual = new MinWindow.MySolution().minWindow("baaaa", "aaaa");
        Assertions.assertEquals("aaaa", actual);
    }

    @Test
    void minWindow6() {
        String actual = new MinWindow.MySolution().minWindow("cabwefgewcwaefgcf", "cae");
        Assertions.assertEquals("cwae", actual);
    }

    @Test
    void minWindow_NeetCode_1() {
        String actual = new MinWindow.NeetCode().minWindow("ADOBECODEBANC", "ABC");
        Assertions.assertEquals("BANC", actual);
    }
}