package com.sedykh.prims_min_spannig_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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

    public static class MySolution {

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
            PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.distance() - b.distance());
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

    public static class Neetcode {

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
                int cost = curr[0];
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
