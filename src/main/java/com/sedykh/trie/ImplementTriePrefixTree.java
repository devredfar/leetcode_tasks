package com.sedykh.trie;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used
 * to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 */
public class ImplementTriePrefixTree {
    public static class Trie {

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int index : getCharIndexes(word)) {
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (int index : getCharIndexes(word)) {
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.word;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int index : getCharIndexes(prefix)) {
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return true;

        }

        private static int charToIndex(char ch) {
            return ch - 'a';
        }

        private static class TrieNode {
            private final TrieNode[] children;
            private boolean word;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.word = false;
            }
        }

        private static int[] getCharIndexes(String world) {
            var chars = world.toCharArray();
            int[] result = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                result[i] = charToIndex(chars[i]);
            }
            return result;
        }
    }


}
