package com.sedykh.sliding_window;

import java.util.Arrays;

/***
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] acc = new int[26];
        int[] expected = new int[26];
        boolean result = false;
        for (char c : s1.toCharArray()) {
            expected[c - 97]++;
        }
        int left = 0;
        int right = 0;
        while (right - left < s1.length()) {
            acc[s2.charAt(right) - 97]++;
            right++;
            result = Arrays.equals(acc, expected);
        }
        while (right - left == s1.length() && right < s2.length() && !result) {
            acc[s2.charAt(right) - 97]++;
            right++;
            acc[s2.charAt(left) - 97]--;
            left++;
            result = Arrays.equals(acc, expected);
        }

        return result;
    }

    public static boolean checkInclusionWithoutArrayComparison(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] acc = new int[26];
        int[] expected = new int[26];
        for (char c : s1.toCharArray()) {
            expected[c - 97]++;
        }

        int matches = 0;
        int left = 0;
        int right = 0;
        while (right - left < s1.length()) {
            acc[s2.charAt(right) - 97]++;
            right++;
        }
        for (int i = 0; i < 26; i++) {
            matches += acc[i] == expected[i] ? 1 : 0;
        }
        while (right - left == s1.length() && right < s2.length() && matches != 26) {
            int rightIndex = s2.charAt(right) - 97;
            acc[rightIndex]++;
            if (acc[rightIndex] == expected[rightIndex]) {
                matches += 1;
            } else if (acc[rightIndex] + 1 == expected[rightIndex]) {
                matches -= 1;
            }
            right++;

            int leftIndex = s2.charAt(left) - 97;
            acc[leftIndex]--;
            if (acc[leftIndex] == expected[leftIndex]) {
                matches += 1;
            } else if (acc[leftIndex] - 1 == expected[leftIndex]) {
                matches -= 1;
            }
            left++;

        }
        return matches == 26;
    }
}