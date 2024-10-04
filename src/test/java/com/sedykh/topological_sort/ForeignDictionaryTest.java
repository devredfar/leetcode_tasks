package com.sedykh.topological_sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ForeignDictionaryTest {

    @Nested
    class MySolution {
        /**
         * Input: ["z","o"]
         * Output: "zo"
         */
        @Test
        void foreignDictionary1() {
            String actual = new ForeignDictionary.MySolution().foreignDictionary(new String[]{"z", "o"});
            Assertions.assertEquals("zo", actual);
        }

        /**
         * Input: ["hrn","hrf","er","enn","rfnn"]
         * Output: "hernf"
         * <p>
         * Explanation:
         * from "hrn" and "hrf", we know 'n' < 'f'
         * from "hrf" and "er", we know 'h' < 'e'
         * from "er" and "enn", we know get 'r' < 'n'
         * from "enn" and "rfnn" we know 'e'<'r'
         * so one possible solution is "hernf"
         */
        @Test
        void foreignDictionary2() {
            String actual = new ForeignDictionary.MySolution().foreignDictionary(new String[]{"hrn", "hrf", "er", "enn", "rfnn"});
            Assertions.assertEquals("hernf", actual);
        }

        /**
         * words=["abc","bcd","cde"]
         * output: edabc
         */
        @Test
        void foreignDictionary3() {
            String actual = new ForeignDictionary.MySolution().foreignDictionary(new String[]{"abc", "bcd", "cde"});
            Assertions.assertEquals("edabc", actual);
        }

        /**
         * words=["wrtkj","wrt"]
         * output: ""
         */
        @Test
        void foreignDictionary4() {
            String actual = new ForeignDictionary.MySolution().foreignDictionary(new String[]{"wrtkj", "wrt"});
            Assertions.assertEquals("", actual);
        }

        /**
         * words=["wrt","wrf","er","ett","rftt","te"]
         * output: "wertf"
         */
        @Test
        void foreignDictionary5() {
            String actual = new ForeignDictionary.MySolution().foreignDictionary(new String[]{"wrt", "wrf", "er", "ett", "rftt", "te"});
            Assertions.assertEquals("wertf", actual);
        }
    }

    @Nested
    class Neetcode {
        /**
         * Input: ["z","o"]
         * Output: "zo"
         */
        @Test
        void foreignDictionary1() {
            String actual = new ForeignDictionary.Neetcode().foreignDictionary(new String[]{"z", "o"});
            Assertions.assertEquals("zo", actual);
        }

        /**
         * Input: ["hrn","hrf","er","enn","rfnn"]
         * Output: "hernf"
         * <p>
         * Explanation:
         * from "hrn" and "hrf", we know 'n' < 'f'
         * from "hrf" and "er", we know 'h' < 'e'
         * from "er" and "enn", we know get 'r' < 'n'
         * from "enn" and "rfnn" we know 'e'<'r'
         * so one possible solution is "hernf"
         */
        @Test
        void foreignDictionary2() {
            String actual = new ForeignDictionary.Neetcode().foreignDictionary(new String[]{"hrn", "hrf", "er", "enn", "rfnn"});
            Assertions.assertEquals("hernf", actual);
        }

        /**
         * words=["abc","bcd","cde"]
         * output: edabc
         */
        @Test
        void foreignDictionary3() {
            String actual = new ForeignDictionary.Neetcode().foreignDictionary(new String[]{"abc", "bcd", "cde"});
            Assertions.assertEquals("edabc", actual);
        }

        /**
         * words=["wrtkj","wrt"]
         * output: ""
         */
        @Test
        void foreignDictionary4() {
            String actual = new ForeignDictionary.Neetcode().foreignDictionary(new String[]{"wrtkj", "wrt"});
            Assertions.assertEquals("", actual);
        }
    }

}