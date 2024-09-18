package com.sedykh.arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The relative order of the elements should be
 * kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were
 * present in nums initially. The remaining elements of nums are not important as well as the size of nums. Return k.
 */
public class RemoveDuplicates {

    public static class MySolution {

        public int removeDuplicates(int[] nums) {
            int posToWrite = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] != nums[i]) {
                    nums[posToWrite] = nums[i];
                    posToWrite++;
                }
            }
            return posToWrite;
        }
    }

    public static class Interesting {

        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int num : nums) {
                if (i == 0 || num != nums[i - 1]) {
                    nums[i] = num;
                    i++;
                }
            }
            return i;
        }
    }
}
