package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSlidingWindowTest {

    @Test
    void maxSlidingWindow_Naive() {
        int[] actual = new MaxSlidingWindow.Naive().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, actual);
    }

    @Test
    void maxSlidingWindow_Naive_2() {
        int[] actual = new MaxSlidingWindow.Naive().maxSlidingWindow(new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, actual);
    }

    @Test
    void maxSlidingWindow_Naive_3() {
        int[] actual = new MaxSlidingWindow.Naive().maxSlidingWindow(new int[]{7, 6, 5, 4, 3, 2, 1, 0}, 3);
        Assertions.assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2}, actual);
    }

    @Test
    void maxSlidingWindow_Naive_4() {
        int[] actual = new MaxSlidingWindow.Naive().maxSlidingWindow(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, 4);
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8}, actual);
    }

    @Test
    void maxSlidingWindow_NeetCodeDeque() {
        int[] actual = new MaxSlidingWindow.NeetCodeDeque().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, actual);
    }

    @Test
    void maxSlidingWindow_NeetCodeDeque_2() {
        int[] actual = new MaxSlidingWindow.NeetCodeDeque().maxSlidingWindow(new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, actual);
    }

    @Test
    void maxSlidingWindow_NeetCodeDeque_3() {
        int[] actual = new MaxSlidingWindow.NeetCodeDeque().maxSlidingWindow(new int[]{7, 6, 5, 4, 3, 2, 1, 0}, 3);
        Assertions.assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2}, actual);
    }

    @Test
    void maxSlidingWindow_NeetCodeDeque_4() {
        int[] actual = new MaxSlidingWindow.NeetCodeDeque().maxSlidingWindow(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, 4);
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8}, actual);
    }

    @Test
    void maxSlidingWindow_LeetCodeDeque() {
        int[] actual = new MaxSlidingWindow.LeetCodeDeque().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, actual);
    }

    @Test
    void maxSlidingWindow_LeetCodeDeque_2() {
        int[] actual = new MaxSlidingWindow.LeetCodeDeque().maxSlidingWindow(new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, actual);
    }

    @Test
    void maxSlidingWindow_LeetCodeDeque_3() {
        int[] actual = new MaxSlidingWindow.LeetCodeDeque().maxSlidingWindow(new int[]{7, 6, 5, 4, 3, 2, 1, 0}, 3);
        Assertions.assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2}, actual);
    }

    @Test
    void maxSlidingWindow_LeetCodeDeque_4() {
        int[] actual = new MaxSlidingWindow.LeetCodeDeque().maxSlidingWindow(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, 4);
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8}, actual);
    }
}