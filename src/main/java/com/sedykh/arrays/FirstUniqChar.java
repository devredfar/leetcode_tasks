package com.sedykh.arrays;

/**
 * 387. First Unique Character in a String
 * <p>
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] acc = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int charIndexInAcc = charArray[i] - 97;
            acc[charIndexInAcc] += 1;
        }
        for (int i = 0; i < charArray.length; i++) {
            int charIndexInAcc = charArray[i] - 97;
            if (acc[charIndexInAcc] == 1) {
                return i;
            }
        }
        return -1;
    }
}
