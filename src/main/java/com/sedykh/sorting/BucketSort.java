package com.sedykh.sorting;

public class BucketSort {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for (int num : nums) {
            bucket[num]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                nums[index] = i;
                index++;
                bucket[i]--;
            }
        }
    }
}
