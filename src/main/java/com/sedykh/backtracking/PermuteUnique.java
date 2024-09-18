package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 47. Permutations II
 * <p>
 * Given a collection of numbers, nums,
 * that might contain duplicates, return all possible unique
 * permutations in any order.
 */
public class PermuteUnique {

    public static class MySolution {

        List<List<Integer>> result = new ArrayList<>();
        int lim = 0;

        public List<List<Integer>> permuteUnique(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            lim = nums.length;
            for (int num : nums) {
                map.compute(num, (k, v) -> (v == null) ? 1 : v + 1);
            }
            backTracking(map, new ArrayList<>());
            return result;
        }

        public void backTracking(
            Map<Integer, Integer> map,
            List<Integer> cur) {
            if (cur.size() == lim) {
                result.add(new ArrayList<>(cur));
                return;
            }
            if (map.isEmpty()) {
                return;
            }
            for (Integer key : new ArrayList<>(map.keySet())) {
                Integer value = map.get(key);
                if (value > 1) {
                    map.put(key, value - 1);
                } else {
                    map.remove(key);
                }
                cur.add(key);
                backTracking(new HashMap<>(map), cur);
                map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static class Optimal {

        private static void process(int[] nums, int i, List<List<Integer>> ans) {
            if (i == 0) {
                List<Integer> t = new ArrayList<>();
                for (int n : nums) {
                    t.add(n);
                }
                ans.add(t);
                return;
            }

            boolean[] isU = new boolean[21];
            for (int j = i; j != -1; j--) {
                int p = nums[j] + 10;
                if (isU[p]) {
                    continue;
                }
                isU[p] = true;
                s(nums, i, j);
                process(nums, i - 1, ans);
                s(nums, i, j);
            }
        }

        public static void s(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ans;
            }

            int l = nums.length;
            process(nums, l - 1, ans);
            return ans;
        }
    }
}


