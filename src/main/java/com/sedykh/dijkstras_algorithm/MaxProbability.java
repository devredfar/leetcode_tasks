package com.sedykh.dijkstras_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1514. Path with Maximum Probability
 * <p>
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a,
 * b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge
 * succProb[i].
 * <p>
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and
 * return its success probability.
 * <p>
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer
 * by at most 1e-5.
 * <p>
 * There is at most one edge between every two nodes.
 */
public class MaxProbability {

    public static class MySolution {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            PriorityQueue<Edge> backlog = new PriorityQueue<>((a, b) -> -Double.compare(a.probability(), b.probability()));
            HashMap<Integer, ArrayList<Edge>> parsedEdges = new HashMap<>();
            HashMap<Integer, Double> probabilities = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                double prob = succProb[i];
                parsedEdges.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Edge(edge[1], prob));
                parsedEdges.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Edge(edge[0], prob));
            }
            backlog.add(new Edge(start_node, 1.0));
            probabilities.put(start_node, 1.0);
            var result = 0.0;
            while (!backlog.isEmpty()) {
                Edge current = backlog.poll();
                int currentNode = current.to();
                double currentProb = current.probability();
                if (currentNode == end_node) {
                    result = Math.max(result, current.probability());
                } else {
                    ArrayList<Edge> neighbors = parsedEdges.getOrDefault(currentNode, new ArrayList<>());
                    for (Edge neighbor : neighbors) {
                        int neighborNode = neighbor.to();
                        double neighborProb = neighbor.probability();
                        double newProb = currentProb * neighborProb;
                        if (!probabilities.containsKey(neighborNode) || probabilities.get(neighborNode) < newProb) {
                            probabilities.put(neighborNode, newProb);
                            backlog.add(new Edge(neighborNode, newProb));
                        }
                    }
                }
            }
            return result;
        }

        record Edge(int to, double probability) {

        }
    }

    public static class MySolutionOptimized {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            PriorityQueue<Object[]> backlog = new PriorityQueue<>((a, b) -> -Double.compare((Double) a[1], (Double) b[1]));
            HashMap<Integer, ArrayList<Object[]>> parsedEdges = new HashMap<>();
            double[] probabilities = new double[n];
            Arrays.fill(probabilities, -1.0);
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                double prob = succProb[i];
                parsedEdges.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Object[]{edge[1], prob});
                parsedEdges.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Object[]{edge[0], prob});
            }
            backlog.add(new Object[]{start_node, 1.0});
            probabilities[start_node] = 1.0;
            var result = 0.0;
            while (!backlog.isEmpty()) {
                Object[] current = backlog.poll();
                Integer currentNode = (Integer) current[0];
                Double currentProb = (Double) current[1];
                if (currentNode == end_node) {
                    result = Math.max(result, currentProb);
                } else {
                    if (parsedEdges.containsKey(currentNode)) {
                        ArrayList<Object[]> neighbors = parsedEdges.get(currentNode);
                        for (Object[] neighbor : neighbors) {
                            Integer neighborNode = (Integer) neighbor[0];
                            Double neighborProb = (Double) neighbor[1];
                            double newProb = currentProb * neighborProb;
                            if (probabilities[neighborNode] == -1 || probabilities[neighborNode] < newProb) {
                                probabilities[neighborNode] = newProb;
                                backlog.add(new Object[]{neighborNode, newProb});
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

    /**
     * Bellman-Ford algorithm
     * <p>
     * Allows to find the shortest paths in graphs with negative weights
     */
    public static class Optimal {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            double[] maxProb = new double[n];
            maxProb[start_node] = 1.0;

            for (int i = 0; i < n - 1; i++) {
                boolean updated = false;
                for (int j = 0; j < edges.length; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    double prob = succProb[j];

                    if (maxProb[u] * prob > maxProb[v]) {
                        maxProb[v] = maxProb[u] * prob;
                        updated = true;
                    }
                    if (maxProb[v] * prob > maxProb[u]) {
                        maxProb[u] = maxProb[v] * prob;
                        updated = true;
                    }
                }
                if (!updated) break;
            }
            return maxProb[end_node];
        }
    }

    public static class NeetCode {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // create the graph
            List<double[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < edges.length; i++) {
                double from = edges[i][0];
                double to = edges[i][1];
                double weight = succProb[i];
                double[] m = new double[2];
                m[0] = to;
                m[1] = weight;
                graph[edges[i][0]].add(m);
                double[] k = new double[2];
                k[0] = from;
                k[1] = weight;
                graph[edges[i][1]].add(k);
            }

            // call dijkstra and return
            return dijkstra(start, end, graph);
        }

        private double dijkstra(int start, int end, List<double[]>[] graph) {
            double[] proTo = new double[graph.length];

            Arrays.fill(proTo, -1);
            proTo[start] = 1;

            PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
            pq.offer(new State(start, 1));

            while (!pq.isEmpty()) {
                State cur = pq.poll();
                int curid = cur.id;
                double curproToStart = cur.prob;

                if (curid == end) {
                    return curproToStart;
                }

                if (proTo[curid] > curproToStart) {
                    continue;
                }

                List<double[]> nexts = graph[curid];
                for (double[] next : nexts) {
                    double proToNext = proTo[curid] * next[1];
                    int idx = (int) next[0];
                    if (proToNext > proTo[idx]) {
                        proTo[idx] = proToNext;
                        pq.offer(new State(idx, proToNext));
                    }
                }
            }

            return 0;
        }

        public record State(int id, double prob) {

        }
    }
}
