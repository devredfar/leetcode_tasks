package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterReplacementTest {

    @Test
    void characterReplacement() {
        int actual = CharacterReplacement.characterReplacement("ABAB", 2);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void characterReplacement2() {
        int actual = CharacterReplacement.characterReplacement("AABABBA", 1);
        Assertions.assertEquals(4, actual);
    }
}