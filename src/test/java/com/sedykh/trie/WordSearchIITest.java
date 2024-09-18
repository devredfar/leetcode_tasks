package com.sedykh.trie;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchIITest {

    @Test
    void findWords() {
        List<String> words = new WordSearchII().findWords(
                new char[][]{{'a', 'b', 'c'}, {'c', 'c', 'c'}},
                new String[]{"abc"});
        assertEquals(List.of("abc"), words);
    }

    @Test
    void findWords3() {
        List<String> words = new WordSearchII().findWords(
                new char[][]{{'a', 'b', 'c'}},
                new String[]{"cba"});
        assertEquals(List.of("cba"), words);
    }

    @Test
    void findWords2() {
        List<String> words = new WordSearchII().findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"});
        assertEquals(List.of("oath","eat"), words);
    }

    @Test
    void findWords4() {
        List<String> words = new WordSearchII().findWords(
                new char[][]{
                        {'o','a','b','n'},
                        {'o','t','a','e'},
                        {'a','h','k','r'},
                        {'a','f','l','v'}},
                new String[]{"oa","oaa"});
        assertEquals(List.of("oa","oaa"), words);
    }
}