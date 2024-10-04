package com.sedykh.topological_sort;

import java.util.*;

/**
 * 269 - Alien dictionary (Foreign Dictionary)
 * <p>
 * There is a foreign language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z"
 * as in English.
 * <p>
 * You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based
 * on the rules of this new language.
 * <p>
 * Derive the order of letters in this language. If the order is invalid, return an empty string. If there are multiple
 * valid order of letters, return any of them.
 * <p>
 * A string a is lexicographically smaller than a string b if either of the following is true:
 * <p>
 * The first letter where they differ is smaller in a than in b. There is no index i such that a[i] != b[i] and a.length
 * < b.length.
 */
public class ForeignDictionary {

    public static class Neetcode {

        private Map<Character, Set<Character>> adj;
        private Map<Character, Boolean> visited;
        private List<Character> result;

        public String foreignDictionary(String[] words) {
            adj = new HashMap<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    adj.putIfAbsent(c, new HashSet<>());
                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i], w2 = words[i + 1];
                int minLen = Math.min(w1.length(), w2.length());
                if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                    return "";
                }
                for (int j = 0; j < minLen; j++) {
                    if (w1.charAt(j) != w2.charAt(j)) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        break;
                    }
                }
            }

            visited = new HashMap<>();
            result = new ArrayList<>();
            for (char c : adj.keySet()) {
                if (dfs(c)) {
                    return "";
                }
            }

            Collections.reverse(result);
            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                sb.append(c);
            }
            return sb.toString();
        }

        private boolean dfs(char ch) {
            if (visited.containsKey(ch)) {
                return visited.get(ch);
            }

            visited.put(ch, true);
            for (char next : adj.get(ch)) {
                if (dfs(next)) {
                    return true;
                }
            }
            visited.put(ch, false);
            result.add(ch);
            return false;
        }
    }

    public static class MySolution {

        public String foreignDictionary(String[] words) {
            HashMap<Character, Set<Character>> adjustmentsMap = new HashMap<>();
            HashMap<Character, Integer> charsAfter = new HashMap<>();
            HashSet<Character> used = new HashSet<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    adjustmentsMap.computeIfAbsent(c, k -> new HashSet<>());
                }
            }
            for (int i = 0; i < words.length - 1; i++) {
                var biggerWord = words[i];
                var smallerWord = words[i + 1];
                int minLen = Math.min(biggerWord.length(), smallerWord.length());
                if (biggerWord.length() > smallerWord.length() &&
                        biggerWord.substring(0, minLen).equals(smallerWord.substring(0, minLen))) {
                    return "";
                }
                for (int j = 0; j < minLen; j++) {
                    char biggerChar = biggerWord.charAt(j);
                    char smallerChar = smallerWord.charAt(j);
                    if (biggerChar != smallerChar) {
                        Set<Character> characters = adjustmentsMap.get(smallerChar);
                        if (!characters.contains(biggerChar)) {
                            characters.add(biggerChar);
                            charsAfter.put(biggerChar, charsAfter.getOrDefault(biggerChar, 0) + 1);
                            used.add(smallerChar);
                            used.add(biggerChar);
                        }
                        break;
                    }
                }
            }
            Queue<Character> queue = new LinkedList<>();
            for (final Character usedChar : used) {
                if (!charsAfter.containsKey(usedChar)) {
                    queue.add(usedChar);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!queue.isEmpty()) {
                char lastChar = queue.poll();
                stringBuilder.append(lastChar);
                Set<Character> adjustments = adjustmentsMap.get(lastChar);
                for (Character adjustment : adjustments) {
                    charsAfter.put(adjustment, charsAfter.get(adjustment) - 1);
                    if (charsAfter.get(adjustment) == 0) {
                        queue.add(adjustment);
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (!used.contains((char) (i + 'a')) && adjustmentsMap.get((char) (i + 'a')) != null) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
            return adjustmentsMap.size() == stringBuilder.length() ? stringBuilder.reverse().toString() : "";
        }
    }

}
