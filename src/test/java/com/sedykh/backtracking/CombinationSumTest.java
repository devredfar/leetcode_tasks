package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class CombinationSumTest {

    @Test
    void combinationSumMySolution() {
        List<List<Integer>> result = new CombinationSum.MySolution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> expected = List.of(List.of(7), List.of(2, 2, 3));
        TestUtils.equalsInAnyOrder(result, expected);
    }

    @Test
    void combinationSumMySolutionImproved() {
        List<List<Integer>> result = new CombinationSum.MySolutionImproved().combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> expected = List.of(List.of(7), List.of(2, 2, 3));
        TestUtils.equalsInAnyOrder(result, expected);
    }

    @Test
    void combinationSumOptimal() {
        List<List<Integer>> result = new CombinationSum.Optimal().combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> expected = List.of(List.of(7), List.of(2, 2, 3));
        TestUtils.equalsInAnyOrder(result, expected);
    }
}