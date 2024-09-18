package com.sedykh.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class WordSearchII {

    private Set<String> result;
    private Trie trie;

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char character : chars) {
                int index = getIndex(character);
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        private boolean startWith(String partOfTheWord) {
            char[] chars = partOfTheWord.toCharArray();
            TrieNode node = root;
            for (char character : chars) {
                int index = getIndex(character);
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }

        private boolean contains(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char character : chars) {
                int index = getIndex(character);
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isWord;
        }

        private static class TrieNode {
            private final TrieNode[] children;
            private boolean isWord;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }

        private static int getIndex(char character) {
            return character - 'a';
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        dfs(board);
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isLowerCase(board[i][j])) {
                    dfs(board, i, j, sb);
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, StringBuilder sb) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }
        if (board[i][j] == '#') {
            return;
        }

        char character = board[i][j];
        sb.append(character);

        board[i][j] = '#';

        String possibleWord = sb.toString();
        if (trie.contains(possibleWord)) {
            result.add(possibleWord);
        }
        if (trie.startWith(possibleWord)) {
            dfs(board, i + 1, j, sb);
            dfs(board, i - 1, j, sb);
            dfs(board, i, j + 1, sb);
            dfs(board, i, j - 1, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = character;
    }
}
