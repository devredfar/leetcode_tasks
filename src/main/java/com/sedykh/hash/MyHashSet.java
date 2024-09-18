package com.sedykh.hash;

import java.util.Arrays;

/**
 * 705. Design HashSet
 * <p>
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * Implement MyHashSet class:
 * <p>
 * void add(key) Inserts the value key into the HashSet. bool contains(key) Returns whether the value key exists in the
 * HashSet or not. void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do
 * nothing.
 */
public class MyHashSet {
    int[] array;

    public MyHashSet() {
        array = new int[16];
        Arrays.fill(array, -1);
    }

    public void add(int key) {
        int bucketNum = getBucketNum(key);
        if (array[bucketNum] == -1) {
            array[bucketNum] = key;
        } else {
            if (array[bucketNum] != key) {
                resize();
                add(key);
            }
        }
    }

    private int getBucketNum(int key) {
        return key % array.length;
    }

    private void resize() {
        var newSize = array.length * 2;
        var oldArray = array;
        array = new int[newSize];
        Arrays.fill(array, -1);
        for (int key : oldArray) {
            if (key != -1) {
                add(key);
            }
        }
    }

    public void remove(int key) {
        int bucketNum = getBucketNum(key);
        array[bucketNum] = -1;
    }

    public boolean contains(int key) {
        int bucketNum = getBucketNum(key);
        return array[bucketNum] == key;
    }
}
