package com.sedykh.binary_search;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the
 * median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class FindMedianSortedArrays {

    public static class MySolution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sumOfArrays = nums1.length + nums2.length;
            int medianNum = sumOfArrays / 2 + 1;
            double result;

            int num1Counter = 0;
            int num2Counter = 0;
            int lastOneValue = 0;
            int previousValue = 0;
            for (int i = 0; i < medianNum; i++) {
                int num1Value = num1Counter < nums1.length ? nums1[num1Counter] : Integer.MAX_VALUE;
                int num2Value = num2Counter < nums2.length ? nums2[num2Counter] : Integer.MAX_VALUE;
                if (num1Value > num2Value) {
                    previousValue = lastOneValue;
                    lastOneValue = num2Value;
                    num2Counter++;
                } else {
                    previousValue = lastOneValue;
                    lastOneValue = num1Value;
                    num1Counter++;
                }
            }
            if (sumOfArrays % 2 == 1) {
                result = lastOneValue;
            } else {
                result = ((double) lastOneValue + previousValue) / 2;
            }
            return result;
        }
    }

    public static class Optimal {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int total = m + n;
            int half = (total + 1) / 2;

            int left = 0;
            int right = m;

            var result = 0.0;

            while (left <= right) {
                int i = left + (right - left) / 2;
                int j = half - i;

                // get the four points around possible median
                int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
                int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
                int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
                int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

                // partition is correct
                if (left1 <= right2 && left2 <= right1) {
                    // even
                    if (total % 2 == 0) {
                        result =
                            (Math.max(left1, left2) + Math.min(right1, right2)) /
                                2.0;
                        // odd
                    } else {
                        result = Math.max(left1, left2);
                    }
                    break;
                }
                // partition is wrong (update left/right pointers)
                else if (left1 > right2) {
                    right = i - 1;
                } else {
                    left = i + 1;
                }
            }
            return result;
        }
    }
}