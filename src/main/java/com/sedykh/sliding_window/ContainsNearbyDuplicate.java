package com.sedykh.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 0;
        Set<Integer> windowContains = new HashSet<>();
        while (r < k && r < nums.length) {
            int elem = nums[r];
            r++;
            if (windowContains.contains(elem)) {
                return true;
            } else {
                windowContains.add(elem);
            }
        }
        for (int i = r; i < nums.length; i++) {
            int elem = nums[i];
            if (windowContains.contains(elem)) {
                return true;
            }
            windowContains.add(elem);
            windowContains.remove(nums[l]);
            l++;
        }
        return false;
    }
}
