package com.sedykh.backtracking;

import java.util.HashMap;

/**
 * 494. Target Sum
 * <p>
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
 * then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
 * expression "+2-1". Return the number of different expressions that you can build, which evaluates to target.
 */
public class FindTargetSumWays {

    public static class Backtracking {

        public int findTargetSumWays(int[] nums, int target) {
            return backtracking(nums, 0, target);
        }

        public int backtracking(int[] nums, int i, int target) {
            if (i == nums.length) {
                if (target == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            var add = backtracking(nums, i + 1, target + nums[i]);
            var substract = backtracking(nums, i + 1, target - nums[i]);
            return add + substract;
        }
    }

    public static class DPWithMemo {

        public int findTargetSumWays(int[] nums, int target) {
            // initialize our memoization hash map.
            HashMap<Integer, Integer> ways = new HashMap<>();
            // Start with sum 0 = 1. As at the start, we have a sum of 0, that
            // occurs 1 time.
            ways.put(0, 1);
            // Iterate all our numbers in nums array:
            for (int num : nums) {
                // initialize a new dp hashmap, as we don't need to remember
                // each sum on each iteration, we just need the new sums
                // we create on every pass.
                HashMap<Integer, Integer> updatedWays = new HashMap<>();
                // iterate over each key, value pair.
                // value = freq, which is the frequency of each sum.
                for (var entity : ways.entrySet()) {
                    int freq = entity.getValue();
                    int sum = entity.getKey();
                    // The new sums we create will be the sum +/- num
                    // so our new keys will be sum + num and sum - num.
                    // The values or frequency of each will be all the
                    // frequencies that each original sum occurred at in
                    // the original dp hash map.
                    updatedWays.put(sum + num, updatedWays.getOrDefault(sum + num, 0) + freq);
                    updatedWays.put(sum - num, updatedWays.getOrDefault(sum - num, 0) + freq);
                }
                // replace our old dp hash map with the updatedWays hash map.
                ways = updatedWays;
            }
            // Return the frequency of target in dp hash map.
            return ways.getOrDefault(target, 0);
        }
    }
}
// 1 1 1 1 1
