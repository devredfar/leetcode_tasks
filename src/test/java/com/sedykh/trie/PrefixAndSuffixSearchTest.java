package com.sedykh.trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixAndSuffixSearchTest {

    @Test
    public void test(){
        var wordFilter = new PrefixAndSuffixSearch.OptimalSolution(new String[]{"abbbba", "abba"});
        int f = wordFilter.f("ab", "ba");
        assertEquals(1, f);
    }

    @Test
    public void test2(){
        var wordFilter = new PrefixAndSuffixSearch.OptimalSolution(new String[]{"appple"});
        int f = wordFilter.f("a", "e");
        assertEquals(0, f);
    }

}