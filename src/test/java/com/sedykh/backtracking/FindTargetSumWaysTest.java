package com.sedykh.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindTargetSumWaysTest {

    @Test
    void findTargetSumWays_Backtracking_one() {
        int actual = new FindTargetSumWays.Backtracking().findTargetSumWays(new int[]{1}, 1);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void findTargetSumWays_Backtracking_zero() {
        int actual = new FindTargetSumWays.Backtracking().findTargetSumWays(new int[]{0}, 0);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void findTargetSumWays_Backtracking_two_zeros() {
        int actual = new FindTargetSumWays.Backtracking().findTargetSumWays(new int[]{0, 0}, 0);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void findTargetSumWays_Backtracking_five_ones_to_three() {
        int actual = new FindTargetSumWays.Backtracking().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        Assertions.assertEquals(5, actual);
    }

    @Test
    void findTargetSumWays_DPWithMemo_one() {
        int actual = new FindTargetSumWays.DPWithMemo().findTargetSumWays(new int[]{1}, 1);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void findTargetSumWays_DPWithMemo_zero() {
        int actual = new FindTargetSumWays.DPWithMemo().findTargetSumWays(new int[]{0}, 0);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void findTargetSumWays_two_zeros() {
        int actual = new FindTargetSumWays.DPWithMemo().findTargetSumWays(new int[]{0, 0}, 0);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void findTargetSumWays_five_ones_to_three() {
        int actual = new FindTargetSumWays.DPWithMemo().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        Assertions.assertEquals(5, actual);
    }
}