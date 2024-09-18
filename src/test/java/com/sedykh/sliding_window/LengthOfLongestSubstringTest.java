package com.sedykh.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LengthOfLongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        int actual = LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, actual);
    }

    @Test
    void lengthOfLongestSubstring2() {
        int actual = LengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, actual);
    }

    @Test
    void lengthOfLongestSubstring3() {
        int actual = LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, actual);
    }
}