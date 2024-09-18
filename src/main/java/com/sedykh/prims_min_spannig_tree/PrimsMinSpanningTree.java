package com.sedykh.prims_min_spannig_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implement Prim's minimum spanning tree algorithm.
 * <p>
 * Given a weighted, undirected graph, find the minimum spanning tree (MST) using Prim's algorithm and return its total
 * weight. If the graph is not connected, the total weight of the minimum spanning tree should be -1.
 * <p>
 * Input: n - the number of vertices in the graph, where (2 <= n <= 100). Each vertex is labeled from 0 to n - 1. edges
 * - a list of tuples, each representing an undirected edge in the form (u, v, w), where u and v are vertices connected
 * by the edge, and w is the weight of the edge, where (1 <= w <= 10).
 */
public class PrimsMinSpanningTree {

    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<int[]>[] adjustments = new List[n];

        for (List<Integer> edge : edges) {
            Integer from = edge.get(0);
            Integer to = edge.get(1);
            Integer weight = edge.get(2);

            if (adjustments[from] == null) {
                adjustments[from] = new ArrayList<>();
            }
            adjustments[from].add(new int[]{to, weight});

            if (adjustments[to] == null) {
                adjustments[to] = new ArrayList<>();
            }
            adjustments[to].add(new int[]{from, weight});
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int weight = 0;
        int treeSize = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<int[]> adjustmentFirst = adjustments[0];
        queue.addAll(adjustmentFirst);

        while (!queue.isEmpty() && treeSize < n) {
            int[] edge = queue.poll();
            int to = edge[0];
            int edgeWeight = edge[1];
            if (!visited[to]) {
                weight += edgeWeight;
                visited[to] = true;
                treeSize++;
            }
            List<int[]> adjustment = adjustments[to];
            if (adjustment == null) {
                continue;
            }
            adjustment.forEach(newEdge -> {
                if (!visited[newEdge[0]]) {
                    queue.add(newEdge);
                }
            });
        }
        return treeSize == n - 1 ? weight : -1;
    }

}
