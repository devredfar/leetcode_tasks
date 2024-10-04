package com.sedykh.min_spannig_tree;

import java.util.*;

/**
 * 1584. Min Cost to Connect All Points
 * <p>
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi,
 * yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi -
 * yj|, where |val| denotes the absolute value of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
 * between any two points.
 */
public class MinCostConnectPoints {

    public static class MySolution_Kruskals {
        public int minCostConnectPoints(int[][] points) {
            if (points.length == 1) {
                return 0;
            }
            Point[] pointsObj = new Point[points.length];
            for (int i = 0; i < points.length; i++) {
                pointsObj[i] = Point.of(points[i]);
            }
            HashMap<Point, Integer> pointsParsed = new HashMap<>();
            for (int i = 0; i < pointsObj.length; i++) {
                pointsParsed.put(pointsObj[i], i);
            }

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < pointsObj.length; i++) {
                for (int j = i + 1; j < pointsObj.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    var distance = calcDistance(pointsObj[i], pointsObj[j]);
                    edges.add(new Edge(pointsObj[i], pointsObj[j], distance));
                }
            }
            edges.sort(Comparator.comparingInt(Edge::distance));
            UnionFind unionFind = new UnionFind(edges.size());

            int cost = 0;
            for (final Edge edge : edges) {
                int a = pointsParsed.get(edge.from());
                int b = pointsParsed.get(edge.to());
                if (unionFind.union(a, b)) {
                    cost += edge.distance();
                }
            }
            return cost;
        }

        private int calcDistance(Point a, Point b) {
            return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
        }

        private record Point(int x, int y) {

            public static Point of(final int[] point) {
                return new Point(point[0], point[1]);
            }
        }

        private record Edge(Point from, Point to, int distance) {

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
                if (parentA == parentB) {
                    return false;
                }
                var rankA = ranks.get(a);
                var rankB = ranks.get(b);
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
        }
    }

    public static class MySolution_Prims {

        public int minCostConnectPoints(int[][] points) {
            if (points.length == 1) {
                return 0;
            }
            Point[] pointsObj = new Point[points.length];
            for (int i = 0; i < points.length; i++) {
                pointsObj[i] = Point.of(points[i]);
            }
            //todo simplify to array;
            HashMap<Point, List<Edge>> adjustments = new HashMap<>();
            for (int i = 0; i < pointsObj.length; i++) {
                for (int j = i + 1; j < pointsObj.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    var distance = calcDistance(pointsObj[i], pointsObj[j]);
                    adjustments.computeIfAbsent(pointsObj[i], (point) -> new ArrayList<>())
                        .add(new Edge(pointsObj[j], distance));
                }
            }
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::distance));
            HashSet<Point> visited = new HashSet<>();
            Point start = pointsObj[0];
            visited.add(start);
            queue.addAll(adjustments.get(start));
            int cost = 0;
            while (!queue.isEmpty() && visited.size() < points.length) {
                Edge edge = queue.poll();
                if (visited.contains(edge.to())) {
                    continue;
                }
                visited.add(edge.to());
                cost += edge.distance();
                List<Edge> edges = adjustments.get(edge.to());
                if (edges == null) {
                    continue;
                }
                edges.forEach(newEdge -> {
                    if (!visited.contains(newEdge.to())) {
                        queue.add(newEdge);
                    }
                });
            }
            return cost;
        }

        private int calcDistance(Point a, Point b) {
            return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
        }

        private record Point(int x, int y) {

            public static Point of(final int[] point) {
                return new Point(point[0], point[1]);
            }
        }

        private record Edge(Point to, int distance) {

        }
    }

    public static class Neetcode_Prims {

        public int minCostConnectPoints(int[][] points) {
            int N = points.length;
            Map<Integer, List<int[]>> adj = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                for (int j = i + 1; j < N; j++) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                    adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
                }
            }

            int res = 0;
            Set<Integer> visit = new HashSet<>();
            PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            minH.offer(new int[]{0, 0});
            while (visit.size() < N) {
                int[] curr = minH.poll();
                int cost = Objects.requireNonNull(curr)[0];
                int i = curr[1];
                if (visit.contains(i)) {
                    continue;
                }
                res += cost;
                visit.add(i);
                for (int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
                    int neiCost = nei[0];
                    int neiIndex = nei[1];
                    if (!visit.contains(neiIndex)) {
                        minH.offer(new int[]{neiCost, neiIndex});
                    }
                }
            }
            return res;
        }
    }


}
