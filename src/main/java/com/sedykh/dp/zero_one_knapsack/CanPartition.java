package com.sedykh.dp.zero_one_knapsack;

/**
 * 416. Partition Equal Subset Sum
 * <p>
 * Given an integer array nums, return true if you can partition the array
 * into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class CanPartition {

    /**
     * time complexity: O(2^n)
     * space complexity: O(n)
     */
    public static class Recursive {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            //hack that allows to lower time complexity to O(2^(n-1))
            return canPartitionHelper(1, nums, nums[0], 0);
        }

        private boolean canPartitionHelper(int i, int[] nums, int sumFirst, int sumSecond) {
            if (i == nums.length) {
                return sumFirst == sumSecond;
            }
            var addedToFirst = canPartitionHelper(i + 1, nums, sumFirst + nums[i], sumSecond);
            var addedToSecond = canPartitionHelper(i + 1, nums, sumFirst, sumSecond + nums[i]);
            return addedToFirst || addedToSecond;
        }
    }

    /**
     * time complexity: O(n*S), where S is the sum of all elements in nums
     * space complexity: O(n*S)
     */
    public static class MemorizationWithRecursion {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[][] cache = new boolean[nums.length][target + 1];
            return canPartitionHelper(0, nums, target, cache);
        }

        private boolean canPartitionHelper(int i,
                                           int[] nums,
                                           int target,
                                           boolean[][] cache) {
            if (target == 0) {
                return true;
            }
            if (i == nums.length) {
                return false;
            }
            if (target < 0) {
                return false;
            }
            if (cache[i][target]) {
                return false;
            }
            cache[i][target] = true;
            var added = canPartitionHelper(i + 1, nums, target - nums[i], cache);
            var notIncluded = canPartitionHelper(i + 1, nums, target, cache);
            return added || notIncluded;
        }
    }

    public static class NeetcodeMemorization {
        // TC = O(n*sum), SC = O(n*sum)
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][target + 1];
            int n = nums.length;
            for (int index = 0; index <= n; index++) {
                for (int currentSum = 0; currentSum <= target; currentSum++) {
                    if (index == 0 || currentSum == 0) {
                        boolean isNotFirstElement = index != 0;
                        dp[index][currentSum] = isNotFirstElement;
                    } else if (currentSum >= nums[index - 1]) {
                        dp[index][currentSum] = dp[index - 1][currentSum] || dp[index - 1][currentSum - nums[index - 1]];
                    } else {
                        dp[index][currentSum] = dp[index - 1][currentSum];
                    }
                }
            }
            return dp[n][target];
        }
    }

    public static class SimplifiedNeetcodeMemorization {
        // TC = O(n*sum), SC = O(n*sum)
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][target + 1];
            for (int index = 0; index <= nums.length - 1; index++) {
                dp[index][0] = true;
                for (int currentSum = 1; currentSum <= target; currentSum++) {
                    int elem = nums[index];
                    int nextIndex = index + 1;
                    if (currentSum >= elem) {
                        dp[nextIndex][currentSum] = dp[index][currentSum] || dp[index][currentSum - elem];
                    } else {
                        dp[nextIndex][currentSum] = dp[index][currentSum];
                    }
                }
            }
            return dp[nums.length][target];
        }
    }

    /**
     * time complexity: O(n*S), where S is the sum of all elements in nums
     * space complexity: O(S)
     */
    public static class DP {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int elem : nums) {
                for (int i = target; i >= 0; i--) {
                    if (dp[i]) {
                        var newSum = i + elem;
                        if (newSum == target) {
                            return true;
                        }
                        if (newSum < target) {
                            dp[newSum] = true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static class DPOptimized {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int elem : nums) {
                for (int i = target; i >= elem; i--) {
                    if (dp[i - elem]) {
                        if (i == target) return true;
                        dp[i] = true;
                    }
                }
            }
            return false;
        }
    }
}

// [1,2,3],[],[]
// i = 0, [1,2,3] / [1],[]; [],[1]
// i = 1, [1,2,3] / [1,2],[]; [1],[2]; [2],[1]; [],[1,2]
// i = 2  [1,2,3] / [1,2,3],[]; [1,2],[3]; [1,3],[2]; [1],[2,3]; [2,3],[1]; [2],[1,3]; [3],[1,2], [],[1,2,3]


// [1,2,3,4],[],[]
// i = 0, [1,2,3,4] / [1]=1,[]=0;
// i = 1, [1,2,3,4] / [1,2]=3,[]=0; [1]=1,[2]=2;
// i = 2  [1,2,3,4] / [1,2,3]=6,[]=0; [1,2]=3,[3]=3; [1,3]=4,[2]=2; [1]=1,[2,3]=5;
// i = 4  [1,2,3,4] / [1,2,3,4]=10,[]=0; [1,2,3]=6,[4]=4; [1,2,4]=7,[3]=3; [1,2]=3,[3,4]=7; [1,3,4]=8,[2]=2; [1,3]=4,[2,4]=6; [1,4]=5,[2,3]=5; [1]=1,[2,3,4]=9;