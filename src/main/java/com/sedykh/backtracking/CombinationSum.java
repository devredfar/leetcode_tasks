package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all
 * unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any
 * order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 */
public class CombinationSum {

    public static class MySolution {

        public final ArrayList<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<Integer> oneSum = new ArrayList<>();
            processRemainingCandidates(candidates, oneSum, 0, target);
            return result;
        }

        private void processRemainingCandidates(int[] candidates,
                                                List<Integer> oneSum,
                                                int currentCandidateId,
                                                int remainingTarget) {
            for (int i = currentCandidateId; i < candidates.length; i++) {
                combinationSumBacktracking(candidates, oneSum, i, remainingTarget);
                oneSum.remove(oneSum.size() - 1);
            }
        }

        private void combinationSumBacktracking(
            int[] candidates,
            List<Integer> oneSum,
            int currentCandidateId,
            int target) {
            int candidate = candidates[currentCandidateId];
            oneSum.add(candidate);
            int remainingTarget = target - candidate;
            if (remainingTarget == 0) {
                result.add(new ArrayList<>(oneSum));
            }
            if (remainingTarget <= 0) {
                return;
            }
            processRemainingCandidates(candidates, oneSum, currentCandidateId, remainingTarget);
        }
    }

    public static class MySolutionImproved {

        public final ArrayList<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<Integer> oneSum = new ArrayList<>();
            Arrays.sort(candidates);
            processRemainingCandidates2(candidates, oneSum, 0, target);
            return result;
        }

        public boolean combinationSumBacktracking2(
            int[] candidates,
            List<Integer> oneSum,
            int currentCandidateId,
            int target) {
            int candidate = candidates[currentCandidateId];
            oneSum.add(candidate);
            int remainingTarget = target - candidate;
            if (remainingTarget == 0) {
                result.add(new ArrayList<>(oneSum));
            }
            if (remainingTarget <= 0) {
                return true;
            }
            processRemainingCandidates2(candidates, oneSum, currentCandidateId, remainingTarget);
            return false;
        }

        private void processRemainingCandidates2(int[] candidates,
                                                 List<Integer> oneSum,
                                                 int currentCandidateId,
                                                 int remainingTarget) {
            boolean isTooBig = false;
            for (int i = currentCandidateId; i < candidates.length && !isTooBig; i++) {
                isTooBig = combinationSumBacktracking2(candidates, oneSum, i, remainingTarget);
                oneSum.remove(oneSum.size() - 1);
            }
        }
    }

    public static class Optimal {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            backtrack(candidates, target, ans, cur, 0);
            return ans;
        }

        public void backtrack(
            int[] candidates,
            int target,
            List<List<Integer>> ans,
            List<Integer> cur,
            int index
        ) {
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            } else {
                if (target >= 0 && index < candidates.length) {
                    cur.add(candidates[index]);
                    backtrack(candidates, target - candidates[index], ans, cur, index);
                    cur.remove(cur.get(cur.size() - 1));
                    backtrack(candidates, target, ans, cur, index + 1);
                }
            }
        }
    }
}
