package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 */
public class LetterCombinations {

    final static char[][] dict = new char[10][];

    static {
        dict[1] = new char[0];
        dict[2] = new char[]{'a', 'b', 'c'};
        dict[3] = new char[]{'d', 'e', 'f'};
        dict[4] = new char[]{'g', 'h', 'i'};
        dict[5] = new char[]{'j', 'k', 'l'};
        dict[6] = new char[]{'m', 'n', 'o'};
        dict[7] = new char[]{'p', 'q', 'r', 's'};
        dict[8] = new char[]{'t', 'u', 'v'};
        dict[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] digitsArray = digits.toCharArray();
        if (digitsArray.length != 0) {
            char[] chars = new char[digits.length()];
            letterCombinations(digitsArray, 0, chars, result);
        }
        return result;
    }

    public void letterCombinations(
        char[] digitsArray,
            int i,
            char[] cur,
            List<String> result) {
        if (i >= digitsArray.length) {
            result.add(new String(cur));
        } else {
            char[] chars = dict[digitsArray[i] - 48];
            for (char character : chars) {
                cur[i] = character;
                letterCombinations(digitsArray, i + 1, cur, result);
            }
        }
    }
}
