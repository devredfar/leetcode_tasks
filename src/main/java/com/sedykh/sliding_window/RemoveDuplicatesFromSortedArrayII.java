package com.sedykh.sliding_window;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        boolean notRepeated = true;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
                notRepeated = true;
            } else if (notRepeated) {
                l++;
                nums[l] = nums[r];
                notRepeated = false;
            }
            r++;
        }
        return l + 1;
    }
}

//  1 1 1 1 2 3 3 4
//  l r
//    l r
