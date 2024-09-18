package com.sedykh.kadanes_algorithm;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 * <p>
 * A subarray is turbulent if the comparison sign flips between each adjacent
 * pair of elements in the subarray.
 * <p>
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr
 * is said to be turbulent if and only if:
 * <p>
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int result = 0;
        if (arr.length == 1) {
            return 1;
        }
        int current = 0;
        Boolean isPrevBigger = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                current = 0;
                isPrevBigger = null;
                result = Math.max(result, current + 1);
                continue;
            }
            boolean isCurrentBigger = arr[i] > arr[i + 1];
            if (isPrevBigger == null) {
                current++;
                isPrevBigger = isCurrentBigger;
                result = Math.max(result, current + 1);
                continue;
            }
            if ((isPrevBigger && isCurrentBigger)
                    || (!isPrevBigger && !isCurrentBigger)) {
                current = 1;
            } else {
                isPrevBigger = isCurrentBigger;
                current++;

            }
            result = Math.max(result, current + 1);
        }
        return result;
    }
}
