package com.sedykh.heap;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * <p>
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3. For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object. void addNum(int num) adds the integer num from the data stream to
 * the data structure. double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual
 * answer will be accepted.
 */
public class FindMedianInADataStream {

    public static class MedianFinder {

        private final PriorityQueue<Integer> maxHeap;
        private final PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> a - b);
            minHeap = new PriorityQueue<>((a, b) -> -a + b);
        }

        public void addNum(int num) {
            minHeap.add(num);
            if (minHeap.size() - maxHeap.size() > 1 ||
                    (!maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek())) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (!minHeap.isEmpty() && minHeap.size() == maxHeap.size()) {
                return ((double) minHeap.peek() + maxHeap.peek()) / 2;
            }
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
