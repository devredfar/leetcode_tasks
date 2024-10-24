package com.sedykh.dp.zero_one_knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxFormTest {

    /**
     * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
     * Output: 4
     * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
     * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
     * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
     */
    @Test
    void findMaxForm() {
        int actual = new FindMaxForm().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        assertEquals(4, actual);
    }

    /**
     * Input: strs = ["10","0","1"], m = 1, n = 1
     * Output: 2
     * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
     */
    @Test
    void findMaxForm2() {
        int actual = new FindMaxForm().findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        assertEquals(2, actual);
    }
}