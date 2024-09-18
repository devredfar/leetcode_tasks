package com.sedykh.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
 * k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosest {

    PriorityQueue<PointWithDistance> queue = new PriorityQueue<>(
        Comparator.comparingDouble(PointWithDistance::distance));

    public int[][] kClosest(int[][] points, int k) {
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            queue.add(new PointWithDistance(x, y, calcDistance(x, y)));
        }
        int resultsCount = Math.min(queue.size(), k);
        int[][] result = new int[resultsCount][];
        for (int i = 0; i < resultsCount; i++) {
            PointWithDistance poll = queue.poll();
            result[i] = new int[]{poll.x(), poll.y()};
        }
        return result;
    }

    private double calcDistance(int x, int y) {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }

    record PointWithDistance(int x, int y, double distance) {

    }
}
