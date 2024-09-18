package com.sedykh.dijkstras_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time
 * <p>
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time
 * it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the minimum time it takes
 * for all the n nodes to receive the signal. If it is impossible for all
 * the n nodes to receive the signal, return -1.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        var shortestPaths = new HashMap<Integer, Integer>();
        shortestPaths.put(k, 0);
        HashMap<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            List<int[]> edgesFromNode = edges.getOrDefault(time[0], new ArrayList<>());
            edgesFromNode.add(new int[]{time[1], time[2]});
            edges.put(time[0], edgesFromNode);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{k, 0});
        while (!minHeap.isEmpty()) {
            int[] path = minHeap.poll();
            List<int[]> edgesFromNode = edges.getOrDefault(path[0], new ArrayList<>());
            for (int[] edge : edgesFromNode) {
                var newWeight = edge[1] + path[1];
                if (!shortestPaths.containsKey(edge[0]) || newWeight < shortestPaths.get(edge[0])) {
                    shortestPaths.put(edge[0], newWeight);
                    minHeap.add(new int[]{edge[0], newWeight});
                }
            }
        }
        return shortestPaths.size() == n ? Collections.max(shortestPaths.values()) : -1;
    }
}
