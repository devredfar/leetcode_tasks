package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class SubsetsTest {

    @Test
    void subsets() {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3});
        TestUtils.equalsInAnyOrder(subsets, TestUtils.parseToList("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]"));
    }

    @Test
    void subsets2() {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{0});
        TestUtils.equalsInAnyOrder(subsets, TestUtils.parseToList("[[],[0]]"));
    }
}