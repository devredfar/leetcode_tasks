package com.sedykh.backtracking;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PermuteUniqueTest {

    @Test
    void permute() {
        List<List<Integer>> permute = new PermuteUnique.MySolution().permuteUnique(new int[]{1, 1, 2});
        Assertions.assertEquals(3, permute.size());
    }

    @Test
    void permute2() {
        List<List<Integer>> permute = new PermuteUnique.MySolution().permuteUnique(new int[]{1, 2, 3});
        Assertions.assertEquals(6, permute.size());
    }

    @Test
    void permuteOptimal() {
        List<List<Integer>> permute = new PermuteUnique.Optimal().permuteUnique(new int[]{1, 1, 2});
        Assertions.assertEquals(3, permute.size());
    }

    @Test
    void permuteOptimal2() {
        List<List<Integer>> permute = new PermuteUnique.Optimal().permuteUnique(new int[]{1, 2, 3});
        Assertions.assertEquals(6, permute.size());
    }
}