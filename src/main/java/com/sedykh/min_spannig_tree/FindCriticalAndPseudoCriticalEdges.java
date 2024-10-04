package com.sedykh.min_spannig_tree;

import java.util.*;

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

    public static class MySolution_Kruskals {

        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            ArrayList<Integer> criticalEdges = new ArrayList<>();
            ArrayList<Integer> pseudoCriticalEdges = new ArrayList<>();

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                edge = Arrays.copyOf(edge, edge.length + 1);
                edge[3] = i;
                edges[i] = edge;
            }

            Arrays.sort(edges, Comparator.comparingInt((int[] a) -> a[2]));

            int minWeight = findMSTWeightKruskals(n, edges, -1, -1);

            for (int i = 0; i < edges.length; i++) {
                if (minWeight < findMSTWeightKruskals(n, edges, i, -1)) {
                    criticalEdges.add(edges[i][3]);
                } else if (minWeight == findMSTWeightKruskals(n, edges, -1, i)) {
                    pseudoCriticalEdges.add(edges[i][3]);
                }
            }

            ArrayList<List<Integer>> result = new ArrayList<>();
            // hack to solve assert in tests problems.
            Collections.sort(criticalEdges);
            Collections.sort(pseudoCriticalEdges);
            result.add(criticalEdges);
            result.add(pseudoCriticalEdges);
            return result;
        }

        private int findMSTWeightKruskals(int n, int[][] edges, int bannedEdgeNum, int includeEdgeNum) {
            int weight = 0;
            UnionFind uf = new UnionFind(n);
            if (includeEdgeNum != -1) {
                weight += edges[includeEdgeNum][2];
                uf.union(edges[includeEdgeNum][0], edges[includeEdgeNum][1]);
            }

            for (int i = 0; i < edges.length; i++) {
                if (i == bannedEdgeNum)
                    continue;

                if (uf.find(edges[i][0]) == uf.find(edges[i][1]))
                    continue;

                uf.union(edges[i][0], edges[i][1]);
                weight += edges[i][2];
            }

            for (int i = 0; i < n; i++) {
                if (uf.find(i) != uf.find(0))
                    return Integer.MAX_VALUE;
            }
            return weight;
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

            public int find(int n) {
                int p = parents.get(n);
                while (p != parents.get(p)) {
                    parents.put(n, parents.get(p));
                    p = parents.get(p);
                }
                return p;
            }

            public boolean union(int a, int b) {
                var parentA = find(a);
                var parentB = find(b);

                if (parentB == parentA) {
                    return false;
                }

                var rankA = ranks.get(parentA);
                var rankB = ranks.get(parentB);

                if (rankA > rankB) {
                    parents.put(parentB, parentA);
                } else if (rankA < rankB) {
                    parents.put(parentA, parentB);
                } else {
                    parents.put(parentA, parentB);
                    ranks.put(rankB, ranks.get(rankB) + 1);
                }
                return true;
            }
        }
    }

    public static class MySolution_Prims {

        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> criticalEdges = new ArrayList<>();
            ArrayList<Integer> pseudoCriticalEdges = new ArrayList<>();
            result.add(criticalEdges);
            result.add(pseudoCriticalEdges);

            var minWeight = findMSTWeightPrims(n, edges, -1, -1);

            for (int i = 0; i < edges.length; i++) {
                var weightWithoutEdge = findMSTWeightPrims(n, edges, i, -1);
                if (weightWithoutEdge > minWeight) {
                    criticalEdges.add(i);
                } else {
                    var weightWithEdge = findMSTWeightPrims(n, edges, -1, i);
                    if (minWeight == weightWithEdge) {
                        pseudoCriticalEdges.add(i);
                    }
                }
            }
            return result;
        }

        private int findMSTWeightPrims(final int n, final int[][] edges, final int bannedEdge, int forcedEdge) {
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
