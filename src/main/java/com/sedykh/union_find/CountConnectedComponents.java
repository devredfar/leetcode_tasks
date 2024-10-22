package com.sedykh.union_find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * There is an undirected graph with n nodes.
 * There is also an edges array, where edges[i] = [a, b]
 * means that there is an edge between node a and node b in the graph.
 * <p>
 * Return the total number of connected components in that graph.
 */
public class CountConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            unionFind.union(a, b);
        }
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueRoots.add(unionFind.find(i));
        }
        return uniqueRoots.size();
    }

    private static class UnionFind {
        private final Map<Integer, Integer> parents;
        private final Map<Integer, Integer> ranks;

        public UnionFind(int n) {
            parents = new HashMap<>();
            ranks = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
                ranks.put(i, 0);
            }
        }

        private int find(int n) {
            int p = parents.get(n);
            while (p != parents.get(p)) {
                parents.put(n, parents.get(p));
                p = parents.get(n);
            }
            return p;
        }

        private boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            if (ranks.get(rootA) < ranks.get(rootB)) {
                parents.put(rootA, rootB);
            } else if (ranks.get(rootA) > ranks.get(rootB)) {
                parents.put(rootB, rootA);
            } else {
                parents.put(rootB, rootA);
                ranks.put(rootA, ranks.get(rootA) + 1);
            }
            return true;
        }
    }
}
