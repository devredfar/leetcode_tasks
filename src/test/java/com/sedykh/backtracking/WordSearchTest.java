package com.sedykh.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearchTest {

    @Test
    void exist() {
        boolean actualResult = new WordSearch().exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCCED");
        Assertions.assertTrue(actualResult);
    }

    @Test
    void exist2() {
        boolean actualResult = new WordSearch().exist(new char[][]{
                        {'A', 'B', 'C'}
                },
                "ABA");
        Assertions.assertFalse(actualResult);
    }


    @Test
    void exist3() {
        boolean actualResult = new WordSearch().exist(new char[][]{
                        {'C','A','A'},
                        {'A','A','A'},
                        {'B','C','D'}
                },
                "AAB");
        Assertions.assertTrue(actualResult);
    }

    @Test
    void exist4() {
        boolean actualResult = new WordSearch().exist(new char[][]{
                        {'A','B','C','E'},
                        {'S','F','E','S'},
                        {'A','D','E','E'}
                },
                "ABCESEEEFS");
        Assertions.assertTrue(actualResult);
    }
}