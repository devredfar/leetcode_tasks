package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <p>
 * Given a string s, partition s such that every
 * substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(0, s, res, path);
        return res;
    }

    public void backtracking(int ind, String s, List<List<String>> res, List<String> cur) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                cur.add(s.substring(ind, i + 1));
                backtracking(i + 1, s, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
