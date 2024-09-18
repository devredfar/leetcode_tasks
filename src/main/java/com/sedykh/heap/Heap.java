package com.sedykh.heap;

/**
 * Design heap
 */
public class Heap {
    int size;
    private final int[] heapArray;

    public Heap(int k) {
        size = 1;
        heapArray = new int[k + 1];
    }

    public int pop() {
        size--;
        int topElement = heapArray[1];
        heapArray[1] = heapArray[size];
        heapArray[size] = 0;
        var current = 1;
        while (current * 2 < size) {
            var leftChild = current * 2;
            var rightChild = current * 2 + 1;
            var currentElement = heapArray[current];
            int leftChildValue = heapArray[leftChild];
            int rightChildValue = heapArray[rightChild];
            if (currentElement > leftChildValue && currentElement > rightChildValue) {
                return topElement;
            }
            if (leftChildValue > rightChildValue) {
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
        while (heapArray[parent] < heapArray[current] && parent != 0) {
            var temp = heapArray[parent];
            heapArray[parent] = heapArray[current];
            heapArray[current] = temp;
            current = parent;
            parent = current / 2;
        }
        size++;
    }
}