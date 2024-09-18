package com.sedykh.backtracking;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class PermuteTest {

    @Test
    void permuteIterative() {
        List<List<Integer>> permute = new Permute.Iterative().permute(new int[]{1, 2, 3});
        TestUtils.equalsInAnyOrder(permute, List.of(
            List.of(3, 2, 1),
            List.of(2, 3, 1),
            List.of(2, 1, 3),
            List.of(3, 1, 2),
            List.of(1, 3, 2),
            List.of(1, 2, 3)
        ));
    }

    @Test
    void permuteIterative2() {
        List<List<Integer>> permute = new Permute.Iterative().permute(new int[]{5, 4, 6, 2});
        TestUtils.equalsInAnyOrder(permute, List.of(
            List.of(2, 6, 4, 5),
            List.of(6, 2, 4, 5),
            List.of(6, 4, 2, 5),
            List.of(6, 4, 5, 2),
            List.of(2, 4, 6, 5),
            List.of(4, 2, 6, 5),
            List.of(4, 6, 2, 5),
            List.of(4, 6, 5, 2),
            List.of(2, 4, 5, 6),
            List.of(4, 2, 5, 6),
            List.of(4, 5, 2, 6),
            List.of(4, 5, 6, 2),
            List.of(2, 6, 5, 4),
            List.of(6, 2, 5, 4),
            List.of(6, 5, 2, 4),
            List.of(6, 5, 4, 2),
            List.of(2, 5, 6, 4),
            List.of(5, 2, 6, 4),
            List.of(5, 6, 2, 4),
            List.of(5, 6, 4, 2),
            List.of(2, 5, 4, 6),
            List.of(5, 2, 4, 6),
            List.of(5, 4, 2, 6),
            List.of(5, 4, 6, 2)
        ));
    }

    @Test
    void permuteOptimal() {
        List<List<Integer>> permute = new Permute.Optimal().permute(new int[]{1, 2, 3});
        TestUtils.equalsInAnyOrder(permute, List.of(
            List.of(3, 2, 1),
            List.of(2, 3, 1),
            List.of(2, 1, 3),
            List.of(3, 1, 2),
            List.of(1, 3, 2),
            List.of(1, 2, 3)
        ));
    }

    @Test
    void permuteOptimale2() {
        List<List<Integer>> permute = new Permute.Optimal().permute(new int[]{5, 4, 6, 2});
        TestUtils.equalsInAnyOrder(permute, List.of(
            List.of(2, 6, 4, 5),
            List.of(6, 2, 4, 5),
            List.of(6, 4, 2, 5),
            List.of(6, 4, 5, 2),
            List.of(2, 4, 6, 5),
            List.of(4, 2, 6, 5),
            List.of(4, 6, 2, 5),
            List.of(4, 6, 5, 2),
            List.of(2, 4, 5, 6),
            List.of(4, 2, 5, 6),
            List.of(4, 5, 2, 6),
            List.of(4, 5, 6, 2),
            List.of(2, 6, 5, 4),
            List.of(6, 2, 5, 4),
            List.of(6, 5, 2, 4),
            List.of(6, 5, 4, 2),
            List.of(2, 5, 6, 4),
            List.of(5, 2, 6, 4),
            List.of(5, 6, 2, 4),
            List.of(5, 6, 4, 2),
            List.of(2, 5, 4, 6),
            List.of(5, 2, 4, 6),
            List.of(5, 4, 2, 6),
            List.of(5, 4, 6, 2)
        ));
    }

}
