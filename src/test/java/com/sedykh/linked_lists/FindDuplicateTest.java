package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FindDuplicateTest {

    @Nested
    class Naive {
        @Test
        void findDuplicate() {
            int actualDup = new FindDuplicate.Naive().findDuplicate(new int[]{1, 3, 4, 2, 2});
            Assertions.assertEquals(2, actualDup);
        }

        @Test
        void findDuplicate2() {
            int actualDup = new FindDuplicate.Naive().findDuplicate(new int[]{3, 1, 3, 4, 2});
            Assertions.assertEquals(3, actualDup);
        }
    }

    @Nested
    class AdditionalMemory {
        @Test
        void findDuplicate() {
            int actualDup = new FindDuplicate.AdditionalMemory().findDuplicate(new int[]{1, 3, 4, 2, 2});
            Assertions.assertEquals(2, actualDup);
        }

        @Test
        void findDuplicate2() {
            int actualDup = new FindDuplicate.AdditionalMemory().findDuplicate(new int[]{3, 1, 3, 4, 2});
            Assertions.assertEquals(3, actualDup);
        }
    }

    @Nested
    class FloydCycleDetection {
        @Test
        void findDuplicate() {
            int actualDup = new FindDuplicate.FloydCycleDetection().findDuplicate(new int[]{1, 3, 4, 2, 2});
            Assertions.assertEquals(2, actualDup);
        }

        @Test
        void findDuplicate2() {
            int actualDup = new FindDuplicate.FloydCycleDetection().findDuplicate(new int[]{3, 1, 3, 4, 2});
            Assertions.assertEquals(3, actualDup);
        }
    }
}