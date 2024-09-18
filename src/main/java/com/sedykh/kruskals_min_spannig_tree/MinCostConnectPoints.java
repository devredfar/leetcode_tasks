package com.sedykh.kruskals_min_spannig_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
