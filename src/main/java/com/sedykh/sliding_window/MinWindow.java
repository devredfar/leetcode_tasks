package com.sedykh.sliding_window;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window. If there is no such
 * substring, return the empty string "". The testcases will be generated such that the answer is unique. A substring is
 * a contiguous non-empty sequence of characters within a string.
 */
public class MinWindow {

    public static class MySolution {

        private static int getIndex(final char c) {
            return c - 97 + 32;
        }

        private static boolean isContainsRequired(
            final int[] acc,
            final int[] expected) {
            for (int i = 0; i < expected.length; i++) {
                if (acc[i] < expected[i]) {
                    return false;
                }
            }
            return true;
        }

        public String minWindow(String s, String t) {
            if (t.length() > s.length()) {
                return "";
            }
            int[] acc = new int[58];
            int[] expected = new int[58];
            char[] stringChars = s.toCharArray();
            for (final char c : t.toCharArray()) {
                expected[getIndex(c)]++;
            }
            int l = 0;
            int r = 0;
            int minL = 0;
            int minR = s.length() + 1;
            boolean found = false;
            while (r < s.length() && l < s.length()) {
                char currentChar = stringChars[r];
                acc[getIndex(currentChar)]++;
                r++;
                while (isContainsRequired(acc, expected)) {
                    found = true;
                    if (minR - minL > r - l) {
                        minR = r;
                        minL = l;
                    }
                    acc[getIndex(stringChars[l])]--;
                    l++;
                }
            }
            return found ? s.substring(minL, minR) : "";
        }
    }

    public static class NeetCode {

        public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (char x : t.toCharArray()) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            int matched = 0;
            int start = 0;
            int minLen = s.length() + 1;
            int subStr = 0;
            for (int endWindow = 0; endWindow < s.length(); endWindow++) {
                char right = s.charAt(endWindow);
                if (map.containsKey(right)) {
                    map.put(right, map.get(right) - 1);
                    if (map.get(right) == 0) matched++;
                }

                while (matched == map.size()) {
                    if (minLen > endWindow - start + 1) {
                        minLen = endWindow - start + 1;
                        subStr = start;
                    }
                    char deleted = s.charAt(start++);
                    if (map.containsKey(deleted)) {
                        if (map.get(deleted) == 0) matched--;
                        map.put(deleted, map.get(deleted) + 1);
                    }
                }
            }
            return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
        }
    }
}
