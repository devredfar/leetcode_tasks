package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class CombinationSum2Test {

    @Test
    void combinationSum2() {
        List<List<Integer>> actualResult = new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> expectedResult = List.of(List.of(1,1,6), List.of(1,2,5), List.of(1,7), List.of(2,6));
        TestUtils.equalsInAnyOrder(actualResult, expectedResult);
    }
}