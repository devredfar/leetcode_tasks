package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * <p>
 * Given an integer array nums that may contain duplicates,
 * return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetsWithDup {

    public static class MySolution {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            subsetsWithDubBackTracking(nums, 0, new ArrayList<>());
            return new ArrayList<>(result);
        }

        private void subsetsWithDubBackTracking(int[] nums, int i, ArrayList<Integer> cur) {
            if (i >= nums.length) {
                result.add(new ArrayList<>(cur));
                return;
            }
            cur.add(nums[i]);
            subsetsWithDubBackTracking(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            subsetsWithDubBackTracking(nums, i + 1, cur);
        }
    }

    public static class Optimal {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            subSet(nums, 0, ans, list);
            return ans;
        }

        public void subSet(
            int[] nums,
            int idx,
            List<List<Integer>> ans,
            List<Integer> list
        ) {
            ans.add(new ArrayList<>(list));

            for (int i = idx; i < nums.length; i++) {
                //skip the duplicate elements
                if (i > idx && nums[i] == nums[i - 1]) continue;
                list.add(nums[i]);
                subSet(nums, i + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
