package com.sedykh.sorting;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int h) {
        if (l<h){
            int pivot = nums[h];
            int i = l - 1;
            for (int j = l; j <= h - 1; j++) {
                if (nums[j] < pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, h);
            quickSort(nums, l, i);
            quickSort(nums, i + 2, h);
        }
    }

    private void swap(int[] nums, int l, int r) {
        var temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
