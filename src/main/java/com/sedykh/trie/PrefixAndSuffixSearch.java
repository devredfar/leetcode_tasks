package com.sedykh.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Design a special dictionary that searches the words in it by a prefix and a suffix.
 * <p>
 * Implement the WordFilter class:
 * <p>
 * WordFilter(string[] words) Initializes the object with the words in the dictionary.
 * f(string pref, string suff) Returns the index of the word in the dictionary,
 * which has the prefix pref and the suffix suff.
 * If there is more than one valid index, return the largest of them.
 * If there is no such word in the dictionary, return -1.
 */
public class PrefixAndSuffixSearch {
    static class WordFilter_something_doesnt_work {

        private final Trie prefixes;
        private final Trie suffixes;

        public WordFilter_something_doesnt_work(String[] words) {
            prefixes = new Trie();
            suffixes = new Trie();
            Set<String> processed = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (processed.contains(word)) {
                    continue;
                }
                prefixes.insert(word, i);
                String reversedWord = new StringBuilder(word).reverse().toString();
                suffixes.insert(reversedWord, i);
                processed.add(word);
            }
        }

        public int f(String pref, String suff) {
            var prefixIndices = prefixes.startsWith(pref);
            String reverseSuff = new StringBuilder(suff).reverse().toString();
            var suffixIndices = suffixes.startsWith(reverseSuff);

            int prefixIndex = prefixIndices.size() - 1;
            int suffixIndex = suffixIndices.size() - 1;

            while (prefixIndex >= 0 && suffixIndex >= 0) {
                int prefixValue = prefixIndices.get(prefixIndex);
                int suffixValue = suffixIndices.get(suffixIndex);

                if (prefixValue == suffixValue)
                    return suffixValue;

                if (suffixValue > prefixValue)
                    suffixIndex--;
                else
                    prefixIndex--;
            }
            return -1;
        }

        private static class TrieNode {
            boolean isWord;
            List<Integer> wordIndexes;
            TrieNode[] children;

            public TrieNode() {
                isWord = false;
                children = new TrieNode[26];
                wordIndexes = new ArrayList<>();
            }
        }

        private static class Trie {
            public static final List<Integer> emptySet = List.of();
            private final TrieNode root = new TrieNode();

            public void insert(String word, int wordIndex) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    int ind = getIndex(c);
                    if (curr.children[ind] == null) {
                        curr.children[ind] = new TrieNode();
                    }
                    curr.children[ind].wordIndexes.add(wordIndex);
                    curr = curr.children[ind];
                }
                curr.isWord = true;
            }

            private boolean contains(String word) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    int ind = getIndex(c);
                    if (curr.children[ind] == null) {
                        return false;
                    }
                    curr = curr.children[ind];
                }
                return curr.isWord;
            }

            private List<Integer> startsWith(String word) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    int ind = getIndex(c);
                    if (curr.children[ind] == null) {
                        return emptySet;
                    }
                    curr = curr.children[ind];
                }
                return curr.wordIndexes;
            }

            private int getIndex(char c) {
                return c - 'a';
            }
        }

    }

    public static class OptimalSolution{

        private static class TrieNode {
            private final TrieNode[] children = new TrieNode[26];
            private final List<Integer> wordIndices = new ArrayList<>();
        }

        private final TrieNode prefixRoot = new TrieNode();
        private final TrieNode suffixRoot = new TrieNode();

        private void insert(final String word, final int start, final int end, final int step, TrieNode root, final int index) {
            for(int i = start; i != end; i += step) {
                int charIndex = word.charAt(i) - 'a';

                if(root.children[charIndex] == null)
                    root.children[charIndex] = new TrieNode();

                root = root.children[charIndex];
                root.wordIndices.add(index);
            }
        }

        public OptimalSolution(final String[] words) {
            final Set<String> set = new HashSet<>();

            for(int i = words.length - 1; i > -1; i--) {
                if(set.contains(words[i]))
                    continue;

                set.add(words[i]);

                insert(words[i], 0, words[i].length(), 1, this.prefixRoot, i);
                insert(words[i], words[i].length() - 1, -1, -1, this.suffixRoot, i);
            }
        }

        public List<Integer> getIndices(final String word, final int start, final int end, final int step, TrieNode root) {
            for(int i = start; i != end; i += step) {
                root = root.children[word.charAt(i) - 'a'];

                if(root == null)
                    return new ArrayList<>();
            }
            return root.wordIndices;
        }

        public int f(final String prefix, final String suffix) {
            final List<Integer> prefixIndices = getIndices(prefix, 0, prefix.length(), 1, this.prefixRoot);
            final List<Integer> suffixIndices = getIndices(suffix, suffix.length() - 1, -1, -1, this.suffixRoot);

            int prefixIndex = 0, suffixIndex = 0;

            while(prefixIndex < prefixIndices.size() && suffixIndex < suffixIndices.size()) {
                int prefixValue = prefixIndices.get(prefixIndex), suffixValue = suffixIndices.get(suffixIndex);

                if(prefixValue == suffixValue)
                    return suffixValue;

                if(suffixValue > prefixValue)
                    suffixIndex++;
                else
                    prefixIndex++;
            }

            return -1;
        }
    }
}
