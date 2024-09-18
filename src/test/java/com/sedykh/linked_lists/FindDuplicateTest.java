package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindDuplicateTest {

    @Test
    void findDuplicate() {
        int actualDup = FindDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2});
        Assertions.assertEquals(2, actualDup);
    }

    @Test
    void findDuplicate2() {
        int actualDup = FindDuplicate.findDuplicate(new int[]{3, 1, 3, 4, 2});
        Assertions.assertEquals(3, actualDup);
    }
}