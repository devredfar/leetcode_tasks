package com.sedykh.trie;

/**
 * Design a data structure that supports adding new words and finding
 * if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that
 * matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
public class DesignAddAndSearchWordsDataStructure {
    public static class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            TrieNode current = root;
            for (char aChar : chars) {
                int index = getIndex(aChar);
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            return search(chars, 0, root);
        }

        public boolean search(char[] chars, int start, TrieNode node) {
            TrieNode current = node;
            for (int i = start; i < chars.length; i++) {
                if (chars[i] == '.') {
                    var result = false;
                    for (int j = 0; j < current.children.length && !result; j++) {
                        if (current.children[j] != null) {
                            result = search(chars, i + 1, current.children[j]);
                        }
                    }
                    return result;
                } else {
                    int index = getIndex(chars[i]);
                    if (current.children[index] == null) {
                        return false;
                    }
                    current = current.children[index];
                }
            }
            return current.isWord;
        }


        public static class TrieNode {
            boolean isWord = false;
            TrieNode[] children = new TrieNode[26];

        }

        public static int getIndex(char ch) {
            return ch - 'a';
        }
    }
}
