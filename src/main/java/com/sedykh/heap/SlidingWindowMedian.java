package com.sedykh.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 480. Sliding Window Median
 * <p>
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle values.
 * <p>
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k.
 * There is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the median array for each window in the original array.
 * Answers within 10-5 of the actual value will be accepted.
 */
public class SlidingWindowMedian {

   public static class OptimalSolution {
       public double[] medianSlidingWindow(int[] nums, int k) {
           double[] res = new double[nums.length - k + 1];
           Map<Integer, Integer> removed = new HashMap<>();

           PriorityQueue<Integer> mins = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
           PriorityQueue<Integer> maxs = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
           for (int i=0; i<k; i++) {
               maxs.add(nums[i]);
               mins.add(maxs.poll());
               if (mins.size() - maxs.size() > 1) {
                   maxs.add(mins.poll());
               }
           }

           for (int i=k; i<=nums.length; i++) {
               res[i-k] = mediane(mins, maxs, k);

               if (i < nums.length) {
                   int balance = nums[i-k] <= mins.peek() ? -1 : 1;
                   markRemove(nums[i-k], removed);

                   if (nums[i] <= mins.peek()) {
                       mins.add(nums[i]);
                       balance++;
                   } else {
                       maxs.add(nums[i]);
                       balance--;
                   }

                   if (balance < 0) {
                       mins.add(maxs.poll());
                   }
                   if (balance > 0) {
                       maxs.add(mins.poll());
                   }

                   tryRemove(mins, removed);
                   tryRemove(maxs, removed);
               }
           }

           return res;
       }

       private void tryRemove(PriorityQueue<Integer> queue, Map<Integer, Integer> removed) {
           while (!queue.isEmpty() && removed.getOrDefault(queue.peek(), 0) > 0) {
               int a = queue.poll();
               removed.put(a, removed.get(a) - 1);
           }
       }

       private void markRemove(int a, Map<Integer, Integer> removed) {
           removed.put(a, removed.getOrDefault(a, 0) + 1);
       }

       private double mediane(PriorityQueue<Integer> mins, PriorityQueue<Integer> maxs, int k) {
           if (k % 2 == 0) {
               double val = mins.peek() * 0.5 + maxs.peek() * 0.5;
               return val;
           } else {
               return mins.peek();
           }
       }
   }

    public static class MySolution {
        PriorityQueue<Long> minHeap;
        PriorityQueue<Long> maxHeap;

        public double[] medianSlidingWindow(int[] nums, int k) {
            ArrayList<Double> results = new ArrayList<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
            minHeap = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));

            for (int i = 0; i < nums.length; i++) {
                addNum(nums[i]);
                if (i >= k) {
                    if (nums[i - k] <= minHeap.peek()) {
                        minHeap.remove((long) nums[i - k]);
                        if (maxHeap.size() - minHeap.size() > 1) {
                            minHeap.add(maxHeap.poll());
                        }
                    } else {
                        maxHeap.remove((long) nums[i - k]);
                        if (minHeap.size() - maxHeap.size() > 1) {
                            maxHeap.add(minHeap.poll());
                        }
                    }
                }
                if (i >= k - 1) {
                    results.add(findMedian());
                }

            }

            double[] doubles = new double[results.size()];
            for (int i = 0; i < results.size(); i++) {
                doubles[i] = results.get(i);
            }
            return doubles;
        }

        public double findMedian() {
            if (!minHeap.isEmpty() && minHeap.size() == maxHeap.size()) {
                return ((double) minHeap.peek() + maxHeap.peek()) / 2;
            }
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }

        public void addNum(long num) {
            minHeap.add(num);
            if (minHeap.size() - maxHeap.size() > 1 ||
                    (!maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek())) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }
    }
}
