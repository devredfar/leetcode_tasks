package com.sedykh.union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices chosen from 1 to n,
 * and was not an edge that already existed. The graph is represented as an array edges
 * of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes
 * ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private static class UnionFind {

        private final Map<Integer, Integer> parents = new HashMap<>();
        private final Map<Integer, Integer> ranks = new HashMap<>();

        public UnionFind(int n) {
            for (int i = 1; i < n; i++) {
                parents.put(i, i);
                ranks.put(i, 0);
            }
        }

        private int find(int n) {
            int p = parents.get(n);
            while (p != parents.get(p)) {
                parents.put(n, parents.get(p));
                p = parents.get(p);
            }
            return p;
        }

        private boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return false;
            }
            int rankA = ranks.get(parentA);
            int rankB = ranks.get(parentB);
            if (rankA > rankB) {
                parents.put(parentB, parentA);
            } else if (rankA < rankB) {
                parents.put(parentA, parentB);
            } else {
                parents.put(parentA, parentB);
                ranks.put(parentB, ranks.get(parentB) + 1);
            }
            return true;
        }
    }
}
