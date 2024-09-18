package com.sedykh.recuresion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ClimbStairsTest {

    @Test
    public void test() {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = climbStairs.climbStairs(2);
        assertEquals(2, n);
    }

    @Test
    public void test2() {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = climbStairs.climbStairs(3);
        assertEquals(3, n);
    }

    @Test
    public void test5() {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = climbStairs.climbStairs(5);
        assertEquals(8, n);
    }

    @Test
    public void test3() {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = climbStairs.climbStairs(44);
        assertEquals(1134903170, n);
    }

    @Test
    public void test4() {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = climbStairs.climbStairsNaive(44);
        assertEquals(1134903170, n);
    }

}