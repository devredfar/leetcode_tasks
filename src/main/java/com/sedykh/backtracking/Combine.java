package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1,n].
 * <p>
 * You may return the answer in any order.
 */
public class Combine {

    public static class MySolution {

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            for (int i = 0; i < n - k + 1; i++) {
                combineBacktracking(nums, k, i, new ArrayList<>());
            }
            return result;
        }

        private void combineBacktracking(int[] nums, int k, int i, ArrayList<Integer> cur) {
            int num = nums[i];
            cur.add(num);
            if (cur.size() == k) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int j = i + 1; j < nums.length; j++) {
                combineBacktracking(nums, k, j, cur);
                int index = cur.size() - 1;
                cur.remove(index);
            }
        }
    }

    public static class Optimal {

        public static void combineBacktracking(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
            if (k == 0) {
                combs.add(new ArrayList<>(comb));
                return;
            }
            for (int i = start; i <= n; i++) {
                comb.add(i);
                combineBacktracking(combs, comb, i + 1, n, k - 1);
                comb.remove(comb.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> combs = new ArrayList<>();
            combineBacktracking(combs, new ArrayList<>(), 1, n, k);
            return combs;
        }
    }
}
