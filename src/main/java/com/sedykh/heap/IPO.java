package com.sedykh.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * <p>
 * Suppose LeetCode will start its IPO soon.
 * In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after
 * finishing at most k distinct projects.
 * <p>
 * You are given n projects where the ith project has a pure profit profits[i] and
 * a minimum capital of capital[i] is needed to start it.
 * <p>
 * Initially, you have w capital. When you finish a project,
 * you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * Pick a list of at most k distinct projects from given projects to maximize your final capital,
 * and return the final maximized capital.
 * <p>
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {

    private record Project(int profit, int capital) {
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Project::profit).reversed());
        PriorityQueue<Project> minHeap = new PriorityQueue<>(Comparator.comparingInt(Project::capital));
        int profit = w;
        for (int i = 0; i < capital.length; i++) {
            minHeap.add(new Project(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) {
            initMaxHeap(maxHeap, minHeap, profit);
            if (!maxHeap.isEmpty()) {
                Project project = maxHeap.poll();
                profit += project.profit();
            }
        }
        return profit;
    }

    private void initMaxHeap(
            PriorityQueue<Project> maxHeap,
            PriorityQueue<Project> minHeap,
            int w) {
        while (!minHeap.isEmpty() && minHeap.peek().capital() <= w) {
            maxHeap.add(minHeap.poll());
        }
    }
}
