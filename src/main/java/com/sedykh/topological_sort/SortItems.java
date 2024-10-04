package com.sedykh.topological_sort;

import java.util.*;

/**
 * 1203. Sort Items by Groups Respecting Dependencies
 * <p>
 * There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to
 * and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group can
 * have no item belonging to it.
 * <p>
 * Return a sorted list of the items such that:
 * <p>
 * The items that belong to the same group are next to each other in the sorted list. There are some relations between
 * these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the
 * sorted array (to the left of the i-th item). Return any solution if there is more than one solution and return an
 * empty list if there is no solution.
 */
public class SortItems {

    public static class MySolution {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            int groupCount = m;
            for (int i = 0; i < n; ++i) {
                if (group[i] == -1) {
                    group[i] = groupCount++;
                }
            }
            List<Integer>[] groupGraph = new ArrayList[groupCount];
            List<Integer>[] itemGraph = new List[n];
            int[] itemIndegree = new int[n];
            int[] groupIndegree = new int[groupCount];
            for (int i = 0; i < groupCount; ++i) {
                groupGraph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                itemGraph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; ++i) {
                groupGraph[group[i]].add(i);
            }
            for (int curr = 0; curr < n; curr++) {
                for (int prev : beforeItems.get(curr)) {
                    itemGraph[prev].add(curr);
                    itemIndegree[curr]++;
                    if (group[prev] != group[curr]) {
                        groupGraph[group[prev]].add(group[curr]);
                        groupIndegree[group[curr]]++;
                    }
                }
            }

            List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree, n);
            List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree, groupCount);

            if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
                return new int[0];
            }

            Map<Integer, List<Integer>> orderedItemsByGroup = new HashMap<>();
            for (int item : itemOrder) {
                orderedItemsByGroup
                        .computeIfAbsent(group[item], k -> new ArrayList<>())
                        .add(item);
            }

            List<Integer> result = new ArrayList<>();
            for (int grp : groupOrder) {
                result.addAll(orderedItemsByGroup.getOrDefault(grp, new ArrayList<>()));
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private List<Integer> topologicalSort(List<Integer>[] graph, int[] indegree, int totalNodes) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < totalNodes; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            List<Integer> sortedList = new ArrayList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                sortedList.add(node);
                for (int neighbor : graph[node]) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            return sortedList.size() == totalNodes ? sortedList : new ArrayList<>();
        }
    }

    public static class Internet {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            int idx = m;
            List<Integer>[] groupItems = new List[n + m];
            int[] itemDegree = new int[n];
            int[] groupDegree = new int[n + m];
            List<Integer>[] itemGraph = new List[n];
            List<Integer>[] groupGraph = new List[n + m];
            Arrays.setAll(groupItems, k -> new ArrayList<>());
            Arrays.setAll(itemGraph, k -> new ArrayList<>());
            Arrays.setAll(groupGraph, k -> new ArrayList<>());
            for (int i = 0; i < n; ++i) {
                if (group[i] == -1) {
                    group[i] = idx++;
                }
                groupItems[group[i]].add(i);
            }
            for (int i = 0; i < n; ++i) {
                for (int j : beforeItems.get(i)) {
                    if (group[i] == group[j]) {
                        ++itemDegree[i];
                        itemGraph[j].add(i);
                    } else {
                        ++groupDegree[group[i]];
                        groupGraph[group[j]].add(group[i]);
                    }
                }
            }
            List<Integer> items = new ArrayList<>();
            for (int i = 0; i < n + m; ++i) {
                items.add(i);
            }
            var groupOrder = topoSort(groupDegree, groupGraph, items);
            if (groupOrder.isEmpty()) {
                return new int[0];
            }
            List<Integer> ans = new ArrayList<>();
            for (int gi : groupOrder) {
                items = groupItems[gi];
                var itemOrder = topoSort(itemDegree, itemGraph, items);
                if (itemOrder.size() != items.size()) {
                    return new int[0];
                }
                ans.addAll(itemOrder);
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private List<Integer> topoSort(int[] degree, List<Integer>[] graph, List<Integer> items) {
            Queue<Integer> q = new LinkedList<>();
            for (int i : items) {
                if (degree[i] == 0) {
                    q.offer(i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int i = q.poll();
                ans.add(i);
                for (int j : graph[i]) {
                    if (--degree[j] == 0) {
                        q.offer(j);
                    }
                }
            }
            return ans.size() == items.size() ? ans : List.of();
        }
    }
}
