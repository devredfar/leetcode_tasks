package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] candidates, int i, int target, ArrayList<Integer> cur) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            var remainingTarget = target - candidates[j];
            if (remainingTarget >= 0) {
                cur.add(candidates[j]);
                backtracking(candidates, j + 1, remainingTarget, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
