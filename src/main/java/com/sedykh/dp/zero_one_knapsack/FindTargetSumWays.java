package com.sedykh.dp.zero_one_knapsack;

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

    public static class DPWithMemo {

        public int findTargetSumWays(int[] nums, int target) {
            var map = new HashMap<Integer, Integer>();
            map.put(0, 1);
            for (int num : nums) {
                HashMap<Integer, Integer> newMap = new HashMap<>();
                map.forEach((k, v) -> {
                    int newKAdd = k + num;
                    newMap.put(newKAdd, newMap.getOrDefault(newKAdd, 0) + v);
                    int newKSubs = k - num;
                    newMap.put(newKSubs, newMap.getOrDefault(newKSubs, 0) + v);
                });
                map = newMap;
            }
            return map.getOrDefault(target, 0);
        }
    }
}
// 1 1 1 1
// 1: -1, +1 Map: -1:1, +1:1
// 2: -1, +1 Map: -2:1, 0:2, +2:1
// 3: -1, +1 Map: -3:1, -1:1, -1:2, +1:2, +1:1, +3:1 -> -3:1, +3:1, -1:3, +1:3
// 4: -1, +1 Map: -4:1, 2:1, -2:3, 0:3, -2:1, 4:1, 0:3, 2:3 -> -4:1, 4:1, 2:4, -2:4, 0:6
// 5: -1, +1 Map: -5:1, 3:1, 1:4, -3:4, -1:6, -3:1, 5:1, 3:4, -1:4, 1:6 -> -5:1, 5:1, 3:5, 1:10, -3:5, -1:10
