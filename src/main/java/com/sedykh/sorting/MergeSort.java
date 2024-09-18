package com.sedykh.sorting;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (r - l > 1) {
            var mid = (r - l) / 2 + l;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid, r);
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int lShift = l;
        int rShift = mid;
        int[] temp = new int[r - l];
        int index = 0;
        while (lShift < mid && rShift < r) {
            int numsLShift = nums[lShift];
            int numsRShift = nums[rShift];
            if (numsLShift > numsRShift) {
                temp[index] = numsRShift;
                rShift++;
            } else {
                temp[index] = numsLShift;
                lShift++;
            }
            index++;
        }
        while (lShift < mid) {
            temp[index] = nums[lShift];
            lShift++;
            index++;
        }
        while (rShift < r) {
            temp[index] = nums[rShift];
            rShift++;
            index++;
        }
        System.arraycopy(temp, 0, nums, l, temp.length);
    }
}
