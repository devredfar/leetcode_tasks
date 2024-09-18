package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class SubsetsWithDupTest {
    @Test
    void subsetsWithDup_MySolution() {
        List<List<Integer>> lists = new SubsetsWithDup.MySolution().subsetsWithDup(new int[]{1, 2, 2});
        TestUtils.equalsInAnyOrder(lists, TestUtils.parseToList("[[],[1],[1,2],[1,2,2],[2],[2,2]]"));
    }

    @Test
    void subsetsWithDup_Optimal() {
        List<List<Integer>> lists = new SubsetsWithDup.Optimal().subsetsWithDup(new int[]{1, 2, 2});
        TestUtils.equalsInAnyOrder(lists, TestUtils.parseToList("[[],[1],[1,2],[1,2,2],[2],[2,2]]"));
    }
}