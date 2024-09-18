package com.sedykh.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    @Test
    void rob_DPWithMemory2_1() {
        int rob = new HouseRobber.DPWithMemoryTwoHouses().rob(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(4, rob);
    }

    @Test
    void rob_DPWithMemory2_2() {
        int rob = new HouseRobber.DPWithMemoryTwoHouses().rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240});
        Assertions.assertEquals(4173, rob);
    }

    @Test
    void rob_DPWithMemory2_3() {
        int rob = new HouseRobber.DPWithMemoryTwoHouses().rob(new int[]{2, 7, 9, 3, 1});
        Assertions.assertEquals(12, rob);
    }

    @Test
    void rob_DPWithMemory_1() {
        int rob = new HouseRobber.DPWithMemory().rob(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(4, rob);
    }

    @Test
    void rob_DPWithMemory_2() {
        int rob = new HouseRobber.DPWithMemory().rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240});
        Assertions.assertEquals(4173, rob);
    }

    @Test
    void rob_DPWithMemory_3() {
        int rob = new HouseRobber.DPWithMemory().rob(new int[]{2, 7, 9, 3, 1});
        Assertions.assertEquals(12, rob);
    }

    @Test
    void rob_Naive_1() {
        int rob = new HouseRobber.Naive().rob(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(4, rob);
    }

    @Test
    void rob_Naive_3() {
        int rob = new HouseRobber.Naive().rob(new int[]{2, 7, 9, 3, 1});
        Assertions.assertEquals(12, rob);
    }
}