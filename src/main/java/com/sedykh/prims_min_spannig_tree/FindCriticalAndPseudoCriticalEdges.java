package com.sedykh.prims_min_spannig_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree
 * <p>
 * Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where
 * edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning
 * tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible
 * total edge weight.
 * <p>
 * Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose
 * deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a
 * pseudo-critical edge is that which can appear in some MSTs but not all.
 * <p>
 * Note that you can return the indices of the edges in any order.
 */
public class FindCriticalAndPseudoCriticalEdges {

    public static class MySolution {

        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> criticalEdges = new ArrayList<>();
            ArrayList<Integer> pseudoCriticalEdges = new ArrayList<>();
            result.add(criticalEdges);
            result.add(pseudoCriticalEdges);

            var minWeight = findWeight(n, edges, -1, -1);

            for (int i = 0; i < edges.length; i++) {
                var weightWithoutEdge = findWeight(n, edges, i, -1);
                if (weightWithoutEdge > minWeight) {
                    criticalEdges.add(i);
                } else {
                    var weightWithEdge = findWeight(n, edges, -1, i);
                    if (minWeight == weightWithEdge) {
                        pseudoCriticalEdges.add(i);
                    }
                }
            }
            return result;
        }

        private int findWeight(final int n, final int[][] edges, final int bannedEdge, int forcedEdge) {
            var treeWithEdge = buildMST(n, edges, bannedEdge, forcedEdge);
            if (treeWithEdge.size() != n - 1) {
                return Integer.MAX_VALUE;
            }
            return countWeight(treeWithEdge);
        }

        private int countWeight(List<Edge> tree) {
            int weight = 0;
            for (final Edge edge : tree) {
                weight += edge.weight();
            }
            return weight;
        }

        private List<Edge> buildMST(int n, int[][] edges, int bannedEdge, int includedEdge) {
            boolean[] visited = new boolean[n];
            List<Edge>[] adjustmentList = new List[n];
            for (int i = 0; i < adjustmentList.length; i++) {
                adjustmentList[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                if (i == bannedEdge) {
                    continue;
                }
                int[] edge = edges[i];
                adjustmentList[edge[0]].add(new Edge(edge[0], edge[1], edge[2], i));
                adjustmentList[edge[1]].add(new Edge(edge[1], edge[0], edge[2], i));
            }
            List<Edge> tree = new ArrayList<>();
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
            if (includedEdge == -1) {
                queue.addAll(adjustmentList[0]);
                visited[0] = true;
            } else {
                int[] edge = edges[includedEdge];
                int from = edge[0];
                int to = edge[1];
                tree.add(new Edge(from, to, edge[2], includedEdge));
                queue.addAll(adjustmentList[from]);
                queue.addAll(adjustmentList[to]);
                visited[from] = true;
                visited[to] = true;
            }
            while (tree.size() < n && !queue.isEmpty()) {
                Edge edge = queue.poll();
                if (!visited[edge.to()]) {
                    visited[edge.from()] = true;
                    visited[edge.to()] = true;
                    tree.add(edge);
                }
                List<Edge> newEdges = adjustmentList[edge.to()];
                for (final Edge newEdge : newEdges) {
                    if (!visited[newEdge.to()]) {
                        queue.add(newEdge);
                    }
                }
            }
            return tree;
        }

        private record Edge(int from, int to, int weight, int num) {

        }
    }
}
