package com.sedykh.sliding_window;

/**
 * Given an array of integers arr and two integers k and threshold,
 * return the number of sub-arrays of size k and average greater than or equal to threshold.
 */
public class NumberOfSubArraysOfSizeKandAverageGreaterThanorEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sumThreshold = threshold * k;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= sumThreshold) {
            result++;
        }
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k];
            if (sum >= sumThreshold) {
                result++;
            }
        }
        return result;
    }
}
