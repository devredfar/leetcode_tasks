package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * <p>
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetsBackTracking(nums, 0, new ArrayList<>());
        return result;
    }

    private void subsetsBackTracking(int[] nums, int i, List<Integer> currentResult) {
        if (i == nums.length) {
            result.add(new ArrayList<>(currentResult));
        } else {
            currentResult.add(nums[i]);
            subsetsBackTracking(nums, i + 1, currentResult);
            currentResult.remove(currentResult.size() - 1);
            subsetsBackTracking(nums, i + 1, currentResult);
        }
    }
}