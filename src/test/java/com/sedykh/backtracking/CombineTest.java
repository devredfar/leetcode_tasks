package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class CombineTest {

    @Test
    void combine() {
        List<List<Integer>> combine = new Combine.MySolution().combine(4, 2);
        TestUtils.equalsInAnyOrder(combine, List.of(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4)));
    }

    @Test
    void combineOptimal() {
        List<List<Integer>> combine = new Combine.Optimal().combine(4, 2);
        TestUtils.equalsInAnyOrder(combine, List.of(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4)));
    }
}