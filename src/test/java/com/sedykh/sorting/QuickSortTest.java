package com.sedykh.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void sortArray() {
        int[] sortedArray = new QuickSort().sortArray(new int[]{2, 3, 1, 5, 6, 4, 7, 9, 10, 8});
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, sortedArray);
    }
}