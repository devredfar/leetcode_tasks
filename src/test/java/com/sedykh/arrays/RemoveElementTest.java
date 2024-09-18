package com.sedykh.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {

    @Test
    void removeElement() {
        int[] nums = {3, 2, 2, 3};
        int[] numsExpected = {2, 2, 2, 3};
        int result = new RemoveElement().removeElement(nums, 3);
        assertEquals(2, result);
        assertArrayEquals(numsExpected, nums);
    }

    @Test
    void removeElement2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] numsExpected = {0, 1, 4, 0, 3, 0, 4, 2};
        int result = new RemoveElement().removeElement(nums, 2);
        assertEquals(5, result);
//        order doesn't matter
//        assertArrayEquals(numsExpected, nums);
    }
}