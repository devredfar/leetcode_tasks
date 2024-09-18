package com.sedykh.backtracking;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromePartitioningTest {

    @Test
    void partition() {
        var result = new PalindromePartitioning().partition("a");
        Assertions.assertEquals(List.of(List.of("a")), result);
    }

    @Test
    void partition2() {
        var result = new PalindromePartitioning().partition("aab");
        Assertions.assertEquals(List.of(List.of("a","a","b"), List.of("aa","b")), result);
    }


    @Test
    void partition3() {
        var result = new PalindromePartitioning().partition("aaa");
        Assertions.assertEquals(List.of(List.of("a","a","a"), List.of("a","aa"), List.of("aa","a"), List.of("aaa")), result);
    }
    @Test
    void isPalindrome() {
        String s = "abcdcba";
        boolean result = PalindromePartitioning.isPalindrome(s, 0,
                s.length() - 1);
        Assertions.assertTrue(result);
    }

    @Test
    void isPalindrome2() {
        String s = "abccba";
        boolean result = PalindromePartitioning.isPalindrome(s, 0,
                s.length() - 1);
        Assertions.assertTrue(result);
    }

    @Test
    void isPalindrome3() {
        String s = "abccba";
        boolean result = PalindromePartitioning.isPalindrome(s, 1,
                s.length() - 2);
        Assertions.assertTrue(result);
    }

    @Test
    void isPalindrome4() {
        String s = "abcdba";
        boolean result = PalindromePartitioning.isPalindrome(s, 1,
                s.length() - 2);
        Assertions.assertFalse(result);
    }
}