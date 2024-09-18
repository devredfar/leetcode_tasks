package com.sedykh.dp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {

    @Test
    void longestCommonSubsequence_NaiveApproach() {
        int actualResult = new LongestCommonSubsequence.NaiveApproach().longestCommonSubsequence("ace", "abcde");
        assertEquals(3, actualResult);
    }

    @Test
    void longestCommonSubsequence_NaiveApproach_2() {
        int actualResult = new LongestCommonSubsequence.NaiveApproach().longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
        assertEquals(2, actualResult);
    }

    @Test
    @Disabled
    void longestCommonSubsequence_NaiveApproach_3() {
        int actualResult = new LongestCommonSubsequence.NaiveApproach().longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq");
        assertEquals(6, actualResult);
    }

    @Test
    void longestCommonSubsequence_NaiveApproach_5() {
        int actualResult = new LongestCommonSubsequence.NaiveApproach().longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr");
        assertEquals(5, actualResult);
    }

    @Test
    @Disabled
    void longestCommonSubsequence_NaiveApproach_6() {
        int actualResult = new LongestCommonSubsequence.NaiveApproach().longestCommonSubsequence("abcba", "abcbcba");
        assertEquals(5, actualResult);
    }

    @Test
    void longestCommonSubsequence_DP() {
        int actualResult = new LongestCommonSubsequence.DP().longestCommonSubsequence("ace", "abcde");
        assertEquals(3, actualResult);
    }

    @Test
    void longestCommonSubsequence_DP_2() {
        int actualResult = new LongestCommonSubsequence.DP().longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
        assertEquals(2, actualResult);
    }

    @Test
    void longestCommonSubsequence_DP_3() {
        int actualResult = new LongestCommonSubsequence.DP().longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq");
        assertEquals(6, actualResult);
    }

    @Test
    void longestCommonSubsequence_DP_5() {
        int actualResult = new LongestCommonSubsequence.DP().longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr");
        assertEquals(5, actualResult);
    }

    @Test
    void longestCommonSubsequence_DP_6() {
        int actualResult = new LongestCommonSubsequence.DP().longestCommonSubsequence("abcba", "abcbcba");
        assertEquals(5, actualResult);
    }

    @Test
    void longestCommonSubsequence_DPOptimal() {
        int actualResult = new LongestCommonSubsequence.DPOptimal().longestCommonSubsequence("ace", "abcde");
        assertEquals(3, actualResult);
    }

    @Test
    void longestCommonSubsequence_DPOptimal_2() {
        int actualResult = new LongestCommonSubsequence.DPOptimal().longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
        assertEquals(2, actualResult);
    }

    @Test
    void longestCommonSubsequence_DPOptimal_3() {
        int actualResult = new LongestCommonSubsequence.DPOptimal().longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq");
        assertEquals(6, actualResult);
    }
    @Test
    void longestCommonSubsequence_DPOptimal_5() {
        int actualResult = new LongestCommonSubsequence.DPOptimal().longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr");
        assertEquals(5, actualResult);
    }

    @Test
    void longestCommonSubsequence_DPOptimal_6() {
        int actualResult = new LongestCommonSubsequence.DPOptimal().longestCommonSubsequence("abcba", "abcbcba");
        assertEquals(5, actualResult);
    }


}