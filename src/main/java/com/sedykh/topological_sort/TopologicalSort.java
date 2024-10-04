package com.sedykh.topological_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Implement topological sort.
 * <p>
 * Topological sort is an algorithm for linearly ordering the vertices of a directed acyclic graph such that for every
 * directed edge (u,v), vertex u comes before v in the ordering.
 * <p>
 * Given a directed graph, perform a topological sort on its vertices and return the order as a list of vertex labels.
 * There may be multiple valid topological sorts for a given graph, so you may return any valid ordering.
 * <p>
 * If the graph contains a cycle, you should return an empty list to indicate that a topological sort is not possible.
 * <p>
 * Input: n - the number of vertices in the graph. Each vertex is labeled from 0 to n - 1. edges - a list of pairs, each
 * representing a directed edge in the form (u, v), where u is the source vertex and v is the destination vertex.
 */
public class TopologicalSort {

    public static class MySolution {
        public List<Integer> topologicalSort(int n, int[][] edges) {
            List<Integer>[] adjustmentsList = new List[n];
            for (int i = 0; i < adjustmentsList.length; i++) {
                adjustmentsList[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                adjustmentsList[edge[0]].add(edge[1]);
            }
            ArrayList<Integer> result = new ArrayList<>();
            HashSet<Integer> visited = new HashSet<>();
            HashSet<Integer> recursionStack = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (dfs(adjustmentsList, visited, recursionStack, result, i)) {
                    return List.of();
                }
            }
            Collections.reverse(result);
            return result;
        }

        private boolean dfs(final List<Integer>[] adjustmentsList,
                            final HashSet<Integer> visited,
                            final HashSet<Integer> recursionStack,
                            final ArrayList<Integer> result,
                            final int i) {
            if (recursionStack.contains(i)) {
                return true;
            }
            if (visited.contains(i)) {
                return false;
            }
            visited.add(i);
            recursionStack.add(i);
            for (int neighbor : adjustmentsList[i]) {
                if (dfs(adjustmentsList, visited, recursionStack, result, neighbor)) {
                    return true;
                }
            }
            recursionStack.remove(i);
            result.add(i);
            return false;
        }
    }
}
