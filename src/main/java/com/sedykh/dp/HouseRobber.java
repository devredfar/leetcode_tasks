package com.sedykh.dp;

/**
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses
 * have security systems connected, and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public static class Naive {

        int[] nums;

        public int rob(int[] nums) {
            this.nums = nums;
            return rob(0, 0);
        }

        private int rob(int start, int sum) {
            if (start > nums.length - 1) {
                return sum;
            }
            var robCurrent = rob(start + 2, sum + nums[start]);
            var robNext = rob(start + 1, sum);
            return Math.max(robCurrent, robNext);
        }
    }

    public static class DPWithMemory {

        int[] nums;

        public int rob(int[] nums) {
            this.nums = nums;
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }

    public static class DPWithMemoryTwoHouses {

        int[] nums;

        public int rob(int[] nums) {
            this.nums = nums;
            if (nums.length == 1) {
                return nums[0];
            }
            int dp0 = 0, dp1 = 0, curr;

            for (int i = 0; i < nums.length; i++) {
                curr = Math.max(dp0 + nums[i], dp1);
                dp0 = dp1;
                dp1 = curr;
            }
            return Math.max(dp0, dp1);
        }
    }
}