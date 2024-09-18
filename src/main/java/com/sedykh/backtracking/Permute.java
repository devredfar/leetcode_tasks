package com.sedykh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permute {

    public static class Iterative {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return result;
            }
            result.add(List.of());
            for (int num : nums) {
                result = insertInAllPossiblePositions(num, result);
            }
            return result;
        }

        private List<List<Integer>> insertInAllPossiblePositions(int num, List<List<Integer>> prev) {
            List<List<Integer>> newList = new ArrayList<>();
            prev.forEach(permutation -> {
                    for (int i = 0; i < permutation.size() + 1; i++) {
                        List<Integer> copyOfList = new ArrayList<>(permutation);
                        copyOfList.add(i, num);
                        newList.add(copyOfList);
                    }
                }
            );
            return newList;
        }
    }

    public static class Optimal {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            function(ans, nums, 0);
            return ans;
        }

        public void function(List<List<Integer>> ans, int[] nums, int start) {
            if (start == nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums)
                    list.add(num);
                ans.add(list);
                return;
            }

            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                function(ans, nums, start + 1);
                swap(nums, start, i);
            }
        }

        public void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
