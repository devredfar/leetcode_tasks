package com.sedykh.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    @Test
    void removeDuplicates2() {
        int[] nums = {1, 2, 3};
        int[] numsExpected = {1, 2, 3};
        int result = new RemoveDuplicates.MySolution().removeDuplicates(nums);
        assertEquals(3, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeDuplicates() {
        int[] nums = {1, 2, 3, 3, 3};
        int[] numsExpected = {1, 2, 3, 3, 3};
        int result = new RemoveDuplicates.MySolution().removeDuplicates(nums);
        assertEquals(3, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeDuplicates3() {
        int[] nums = {1,1,2};
        int[] numsExpected = {1, 2, 2};
        int result = new RemoveDuplicates.MySolution().removeDuplicates(nums);
        assertEquals(2, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeDuplicatesInteresting1() {
        int[] nums = {1, 2, 3};
        int[] numsExpected = {1, 2, 3};
        int result = new RemoveDuplicates.Interesting().removeDuplicates(nums);
        assertEquals(3, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeDuplicatesInteresting2() {
        int[] nums = {1, 2, 3, 3, 3};
        int[] numsExpected = {1, 2, 3, 3, 3};
        int result = new RemoveDuplicates.Interesting().removeDuplicates(nums);
        assertEquals(3, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeDuplicatesInteresting3() {
        int[] nums = {1, 1, 2};
        int[] numsExpected = {1, 2, 2};
        int result = new RemoveDuplicates.Interesting().removeDuplicates(nums);
        assertEquals(2, result);
        assertArrayEquals(numsExpected, nums);
    }
}