package com.sedykh.binary_search;

/**
 * 704. Binary Search
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a
 * function to search target in nums. If target exists, then return its index. Otherwise, return -1. You must write an
 * algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            //left sorted
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {//right sorted
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }

        return -1;
    }
}
