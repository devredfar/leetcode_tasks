package com.sedykh.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VersionControlTest {

    @Test
    void firstBadVersion() {
        var actual = new VersionControl() {
            @Override
            public boolean isBadVersion(final int n) {
                return n >= 4;
            }
        }.firstBadVersion(5);
        Assertions.assertEquals(4, actual);
    }
}