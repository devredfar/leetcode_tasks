package com.sedykh.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @Test
    void sortArray() {
        int[] sortedArray = new InsertionSort().sortArray(new int[]{2, 3, 4, 1, 5});
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray);
    }
}