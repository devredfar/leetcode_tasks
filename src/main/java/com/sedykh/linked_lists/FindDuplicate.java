package com.sedykh.linked_lists;

/**
 * 287. Find the Duplicate Number
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and using only constant extra space.
 * <p>
 * Constraints:
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindDuplicate {

    public static class Naive {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j && nums[i] == nums[j]) {
                        return nums[i];
                    }
                }
            }
            return -1;
        }
    }

    /**
     * Time complexity O(n), Space complexity O(n).
     */
    public static class AdditionalMemory {
        public int findDuplicate(int[] nums) {
            boolean[] exist = new boolean[nums.length];
            for (int num : nums) {
                if (exist[num]) {
                    return num;
                }
                exist[num] = true;
            }
            return -1;
        }
    }

    /**
     * Time complexity O(n), Space complexity O(1).
     * the array can be visualized as a directed graph (where each element points to another),
     * this movement will eventually lead the two pointers to meet in a cycle if there is a duplicate
     * (which forms the cycle).
     */
    public static class FloydCycleDetection {
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            while (slow != fast);

            int slow2 = 0;

            do {
                slow = nums[slow];
                slow2 = nums[slow2];
            }

            while (slow != slow2);

            return slow2;
        }
    }

}
