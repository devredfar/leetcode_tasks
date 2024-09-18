package com.sedykh.dp;

import java.util.HashMap;

/**
 * 1143. Longest Common Subsequence
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two strings is a subsequence that is common
 * to both strings.
 */
public class LongestCommonSubsequence {

    //Time complexity: O(n*m), Space complexity: O(n)
    public static class DPOptimal {

        public int longestCommonSubsequence(String text1, String text2) {
            int[] dp = new int[text1.length()];
            int longest = 0;

            for (char c : text2.toCharArray()) {
                int curLength = 0;
                for (int i = 0; i < dp.length; i++) {
                    if (curLength < dp[i]) {
                        curLength = dp[i];
                    } else if (c == text1.charAt(i)) {
                        dp[i] = curLength + 1;
                        longest = Math.max(longest, curLength + 1);
                    }
                }
            }
            return longest;
        }
    }

    //Time complexity: O(n*m), Space complexity: O(n*m)
    public static class DP {

        public int longestCommonSubsequence(String text1, String text2) {
            int[][] accum = new int[text1.length()][text2.length()];
            for (int row = text1.length() - 1; row >= 0; row--) {
                for (int col = text2.length() - 1; col >= 0; col--) {
                    if (text1.charAt(row) == text2.charAt(col)) {
                        accum[row][col] = getValue(accum, row + 1, col + 1) + 1;
                    } else {
                        accum[row][col] = Math.max(
                            getValue(accum, row + 1, col),
                            getValue(accum, row, col + 1));
                    }
                }
            }
            return accum[0][0];
        }

        public int getValue(int[][] accum, int row, int col) {
            if (row >= accum.length || col >= accum[0].length) {
                return 0;
            }
            return accum[row][col];
        }
    }

    // has some error, doesn't really matter, cause to big complexity
    static class NaiveApproach {

        public int longestCommonSubsequence(String text1, String text2) {
            char[] text1Array = text1.toCharArray();
            char[] text2Array = text2.toCharArray();
            return Math.max(
                internalLongestCommon(text1Array, text2Array),
                internalLongestCommon(text2Array, text1Array)
            );
        }

        private static int internalLongestCommon(char[] sourceArray, char[] substringArray) {
            int result = 0;
            var substringMap = getCharIndexMap(substringArray);
            for (int i = 0; i < sourceArray.length && i + result < sourceArray.length; i++) {
                var current = getLongestCommonStartingFrom(i, sourceArray, substringMap);
                result = Math.max(result, current);
            }
            return result;
        }

        private static HashMap<Character, Integer> getCharIndexMap(char[] substringArray) {
            var substringMap = new HashMap<Character, Integer>();
            for (int i = 0; i < substringArray.length; i++) {
                substringMap.put(substringArray[i], i);
            }
            return substringMap;
        }

        private static int getLongestCommonStartingFrom(int start,
                                                        char[] sourceArray,
                                                        HashMap<Character, Integer> substringArray) {
            int lastIndexInSubstring = 0;
            var result = 0;
            for (int i = start; i < sourceArray.length; i++) {
                var indexOfChar = substringArray.getOrDefault(sourceArray[i], -1);
                if (indexOfChar >= lastIndexInSubstring) {
                    lastIndexInSubstring = indexOfChar + 1;
                    result++;
                }
            }
            return result;
        }
    }
}
