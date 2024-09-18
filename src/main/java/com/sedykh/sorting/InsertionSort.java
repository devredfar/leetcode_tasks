package com.sedykh.sorting;

public class InsertionSort {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            var j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                var temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }
}
