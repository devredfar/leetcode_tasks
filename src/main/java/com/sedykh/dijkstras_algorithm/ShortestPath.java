package com.sedykh.dijkstras_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Dijkstra's Algorithm
 * <p>
 * Implement Dijkstra's shortest path algorithm.
 * <p>
 * Given a weighted, directed graph, and a starting vertex,
 * return the shortest distance from the starting vertex to every vertex in the graph.
 * <p>
 * Input:
 * <p>
 * n - the number of vertices in the graph, where (2 <= n <= 100).
 * Each vertex is labeled from 0 to n - 1.
 * edges - a list of tuples, each representing a directed edge in the form (u, v, w),
 * where u is the source vertex, v is the destination vertex, and w is the weight of the edge,
 * where (1 <= w <= 10).
 * src - the source vertex from which to start the algorithm, where (0 <= src < n).
 * Note: If a vertex is unreachable from the source vertex, the shortest path distance
 * for the unreachable vertex should be -1.
 */
public class ShortestPath {

    public static class MySolution {

        public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
            HashMap<Integer, Integer> result = new HashMap<>();
            PriorityQueue<Edge> backlog = new PriorityQueue<>(Comparator.comparingInt(Edge::weight).reversed());
            result.put(src, 0);
            HashMap<Integer, List<Edge>> edgesMap = new HashMap<>();
            edges.forEach(edge -> {
                List<Edge> nodes = edgesMap.getOrDefault(edge.get(0), new ArrayList<>());
                nodes.add(new Edge(edge.get(1), edge.get(2)));
                edgesMap.put(edge.get(0), nodes);
            });
            backlog.add(new Edge(src, 0));
            while (!backlog.isEmpty()) {
                Edge path = backlog.poll();
                List<Edge> nodeEdges = edgesMap.getOrDefault(path.to(), Collections.emptyList());
                var pathWeight = path.weight();
                nodeEdges.forEach(edge -> {
                    var updatedWeight = edge.weight() + pathWeight;
                    if (!result.containsKey(edge.to()) || updatedWeight < result.get(edge.to())) {
                        result.put(edge.to(), updatedWeight);
                        backlog.add(new Edge(edge.to(), updatedWeight));
                    }
                });
            }
            for (int i = 0; i < n; i++) {
                result.putIfAbsent(i, -1);
            }
            return result;
        }

        private record Edge(int to, int weight) {

        }
    }

    public static class Simplified {

        public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
            HashMap<Integer, Integer> shortestDistances = new HashMap<>();
            PriorityQueue<Integer> backlog = new PriorityQueue<>((a, b) -> -a.compareTo(b));
            shortestDistances.put(src, 0);
            HashMap<Integer, List<int[]>> edgesMap = new HashMap<>();
            edges.forEach(edge -> {
                List<int[]> nodes = edgesMap.getOrDefault(edge.get(0), new ArrayList<>());
                nodes.add(new int[]{edge.get(1), edge.get(2)});
                edgesMap.put(edge.get(0), nodes);
            });
            backlog.add(src);
            while (!backlog.isEmpty()) {
                int point = backlog.poll();
                List<int[]> nodeEdges = edgesMap.getOrDefault(point, Collections.emptyList());
                var pathWeight = shortestDistances.get(point);
                nodeEdges.forEach(edge -> {
                    var updatedWeight = edge[1] + pathWeight;
                    int edgeTo = edge[0];
                    if (!shortestDistances.containsKey(edgeTo) || updatedWeight < shortestDistances.get(edgeTo)) {
                        shortestDistances.put(edgeTo, updatedWeight);
                        backlog.add(edgeTo);
                    }
                });
            }
            for (int i = 0; i < n; i++) {
                shortestDistances.putIfAbsent(i, -1);
            }
            return shortestDistances;
        }
    }
}
