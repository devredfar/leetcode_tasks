package com.sedykh.kruskals_min_spannig_tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement Kruskal's minimum spanning tree algorithm.
 * <p>
 * Given a weighted, undirected graph, find the minimum spanning tree (MST) using Kruskal's algorithm and return its
 * total weight. If the graph is not connected, the total weight of the minimum spanning tree should be -1.
 * <p>
 * Input: n - the number of vertices in the graph, where (2 <= n <= 100). Each vertex is labeled from 0 to n - 1. edges
 * - a list of tuples, each representing an undirected edge in the form (u, v, w), where u and v are vertices connected
 * by the edge, and w is the weight of the edge, where (1 <= w <= 10).
 */
public class KruskalsMinSpanningTree {

    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        UnionFind unionFind = new UnionFind(n);
        edges.sort((a, b) -> a.get(2) - b.get(2));
        int totalWeight = 0;
        int count = 0;
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            if (unionFind.union(u, v)) {
                totalWeight += weight;
                count++;
                if (count == n - 1) {
                    return totalWeight;
                }
            }
        }
        return -1;
    }

    private static class UnionFind {

        private final Map<Integer, Integer> parents = new HashMap<>();
        private final Map<Integer, Integer> ranks = new HashMap<>();

        public UnionFind(int n) {
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
                ranks.put(i, 0);
            }
        }

        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return false;
            }
            int rankA = ranks.get(a);
            int rankB = ranks.get(b);
            if (rankA > rankB) {
                parents.put(parentB, parentA);
            } else if (rankB > rankA) {
                parents.put(parentA, parentB);
            } else {
                parents.put(parentA, parentB);
                ranks.put(parentB, ranks.get(parentB) + 1);
            }
            return true;
        }

        public int find(int n) {
            int p = parents.get(n);
            while (p != parents.get(p)) {
                parents.put(n, parents.get(p));
                p = parents.get(p);
            }
            return p;
        }
    }
}
