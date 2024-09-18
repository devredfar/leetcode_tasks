package com.sedykh.heap;

import java.util.PriorityQueue;

/***
 * 703. Kth Largest Element in a Stream
 * <p>
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Implement KthLargest class:
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing
 * the kth largest element in the stream.
 */
public class KthLargest {

    public static class KthLargestWithMinHeap {

        private final MinHeap heap;
        private final int k;

        public KthLargestWithMinHeap(int k, int[] nums) {
            heap = new MinHeap(k + 1);
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (heap.size < k + 1) {
                heap.add(val);
            } else if (heap.peek() < val) {
                heap.pop();
                heap.add(val);
            }
            return heap.peek();
        }

        public static class MinHeap {

            private final int[] heapArray;
            int size;

            public MinHeap(int k) {
                size = 1;
                heapArray = new int[k + 1];
            }

            public int peek() {
                return heapArray[1];
            }

            public int pop() {
                size--;
                int topElement = heapArray[1];
                int newTop = heapArray[size];
                heapArray[1] = newTop;
                heapArray[size] = 0;
                var current = 1;
                while (current * 2 < size) {
                    var leftChild = current * 2;
                    var rightChild = current * 2 + 1;
                    var currentElement = heapArray[current];
                    int leftChildValue = heapArray[leftChild];
                    int rightChildValue;
                    if (rightChild < size) {
                        rightChildValue = heapArray[rightChild];
                    } else {
                        rightChildValue = currentElement;

                    }
                    if (currentElement < leftChildValue && currentElement < rightChildValue) {
                        return topElement;
                    }
                    if (leftChildValue < rightChildValue) {
                        heapArray[current] = leftChildValue;
                        heapArray[leftChild] = currentElement;
                        current = leftChild;
                    } else {
                        heapArray[current] = rightChildValue;
                        heapArray[rightChild] = currentElement;
                        current = rightChild;
                    }
                }
                return topElement;
            }

            public void add(int value) {
                heapArray[size] = value;
                var current = size;
                int parent = current / 2;
                while (heapArray[parent] > heapArray[current] && parent != 0) {
                    var temp = heapArray[parent];
                    heapArray[parent] = heapArray[current];
                    heapArray[current] = temp;
                    current = parent;
                    parent = current / 2;
                }
                size++;
            }
        }
    }


    static class KthLargestWithPriorityQueue {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        final int k;

        public KthLargestWithPriorityQueue(int k, int[] nums) {
            this.k = k;
            for (int n : nums) add(n);
        }

        public int add(int val) {
            if (queue.size() < k) queue.offer(val); //for adding the values of the array
            else if (val > queue.peek()) {
                queue.poll(); //remove the top element
                queue.add(val); //add the new element
            }
            return queue.peek();
        }
    }
}
