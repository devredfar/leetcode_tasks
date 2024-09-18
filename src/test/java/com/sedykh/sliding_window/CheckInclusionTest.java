package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckInclusionTest {

    @Test
    void checkInclusion() {
        boolean actual = CheckInclusion.checkInclusion("ab", "eidbaooo");
        Assertions.assertTrue(actual);
    }

    @Test
    void checkInclusion2() {
        boolean actural = CheckInclusion.checkInclusion("ab", "eidboaoo");
        Assertions.assertFalse(actural);
    }

    @Test
    void checkInclusion3() {
        boolean actural = CheckInclusion.checkInclusion("adc", "dcda");
        Assertions.assertTrue(actural);
    }

    @Test
    void checkInclusion4() {
        boolean actual = CheckInclusion.checkInclusionWithoutArrayComparison("ab", "eidbaooo");
        Assertions.assertTrue(actual);
    }

    @Test
    void checkInclusion5() {
        boolean actural = CheckInclusion.checkInclusionWithoutArrayComparison("ab", "eidboaoo");
        Assertions.assertFalse(actural);
    }

    @Test
    void checkInclusion6() {
        boolean actural = CheckInclusion.checkInclusionWithoutArrayComparison("adc", "dcda");
        Assertions.assertTrue(actural);
    }

    @Test
    void checkInclusion7() {
        boolean actural = CheckInclusion.checkInclusionWithoutArrayComparison("abc", "bbbca");
        Assertions.assertTrue(actural);
    }
}