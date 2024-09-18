package com.sedykh.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstringWithAdditionalMemory(String s) {
        if (s.isEmpty()) return 0;
        char[] charArray = s.toCharArray();
        int result = 0;
        int[] acc = new int[255];
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (acc[charArray[right]] == 0) {
                acc[charArray[right]]++;
                right++;
                result = Math.max(result, right - left);
            } else {
                acc[charArray[left]]--;
                left++;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        int result = 1;
        char[] sc = s.toCharArray();
        for (; rightIndex < sc.length; rightIndex++) {
            if (leftIndex == rightIndex) {
                continue;
            }
            for (int j = leftIndex; j < rightIndex; j++) {
                if (sc[rightIndex] == sc[j]) {
                    leftIndex = j + 1;
                    break;
                }
            }
            result = Math.max(rightIndex - leftIndex + 1, result);
        }
        return result;
    }

    public static int lengthOfLongestSubstringWithListNotOptimal(String s) {
        List<Character> substringL = new ArrayList<>();
        int largestlength = 0;
        for(int right = 0; right < s.length(); right++) {
            if(substringL.contains(s.charAt(right))) {
                // get the index of the char
                int index = substringL.indexOf(s.charAt(right));
                substringL.remove(index);
                if(index > 0)
                    substringL.subList(0, index).clear();
            }
            substringL.add(s.charAt(right));
            largestlength = Math.max(largestlength, substringL.size());
        }
        return largestlength;
    }
}
