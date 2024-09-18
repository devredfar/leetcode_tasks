package com.sedykh.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 * by one position.
 * <p>
 * Return the max sliding window.
 */
public class MaxSlidingWindow {

    public static class Naive {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int l = 0;
            int r = 0;
            int[] result = new int[nums.length - k + 1];
            int currentMax = Integer.MIN_VALUE;
            int currentMaxIndex = -1;
            int resultIndex = 0;
            while (r < k) {
                if (nums[r] > currentMax) {
                    currentMax = nums[r];
                    currentMaxIndex = r;
                }
                r++;
            }
            result[resultIndex++] = currentMax;

            while (r < nums.length) {
                if (nums[r] > currentMax) {
                    currentMax = nums[r];
                    currentMaxIndex = r;
                }
                if (l == currentMaxIndex) {
                    currentMax = Integer.MIN_VALUE;
                    int fastForwardIndex = currentMaxIndex;
                    while (fastForwardIndex < r) {
                        fastForwardIndex++;
                        if (nums[fastForwardIndex] > currentMax) {
                            currentMax = nums[fastForwardIndex];
                            currentMaxIndex = fastForwardIndex;
                        }
                    }
                }
                result[resultIndex++] = currentMax;
                r++;
                l++;
            }
            return result;
        }
    }

    public static class NeetCodeDeque {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> windowIndexes = new ArrayDeque<>();
            int l = 0;
            int r = 0;

            while (r < nums.length) {

                if (!windowIndexes.isEmpty() && l > windowIndexes.peekFirst()) {
                    windowIndexes.pollFirst();
                }

                while (!windowIndexes.isEmpty() && nums[windowIndexes.peekLast()] < nums[r]) {
                    windowIndexes.pollLast();
                }
                windowIndexes.addLast(r);

                if (r + 1 >= k) {
                    result[l] = nums[windowIndexes.peekFirst()];
                    l++;
                }
                r++;
            }

            return result;
        }
    }

    public static class LeetCodeDeque {

        public int[] maxSlidingWindow(int[] nums, int k) {
            // assume nums is not null
            int n = nums.length;
            if (n == 0 || k == 0) {
                return new int[0];
            }
            int[] result = new int[n - k + 1]; // number of windows
            Deque<Integer> win = new ArrayDeque<>(); // stores indices

            for (int i = 0; i < n; ++i) {
                // remove indices that are out of bound
                while (!win.isEmpty() && win.peekFirst() <= i - k) {
                    win.pollFirst();
                }
                // remove indices whose corresponding values are less than nums[i]
                while (!win.isEmpty() && nums[win.peekLast()] < nums[i]) {
                    win.pollLast();
                }
                // add nums[i]
                win.offerLast(i);
                // add to result
                if (i >= k - 1) {
                    result[i - k + 1] = nums[win.peekFirst()];
                }
            }
            return result;
        }
    }
}
