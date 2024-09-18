package com.sedykh.sliding_window;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        int[] chasCounted = new int[26];
        while (right < s.length()) {
            chasCounted[s.charAt(right) - 'A']++;
            max = Math.max(max, chasCounted[s.charAt(right) - 'A']);
            if (right - left - max +1> k) {
                chasCounted[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }

    public int characterReplacementFastestOne(String s, int k) {
        byte[] array = s.getBytes();
        for (int i = 0; i < array.length; i++) array[i] -= 'A';
        int[] count = new int[26];
        int start = 0;
        for (int end = 0, maxCount = 0; end < array.length; end++) {
            maxCount = Math.max(maxCount, ++count[array[end]]);
            while (maxCount + k < end - start + 1) count[array[start++]]--;
        }
        return array.length - start;
    }
}
