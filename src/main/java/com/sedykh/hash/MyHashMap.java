package com.sedykh.hash;

import java.util.Arrays;

/**
 * 706. Design HashMap
 * <p>
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * Implement the MyHashMap class:
 * <p>
 * MyHashMap() initializes the object with an empty map. void put(int key, int value) inserts a (key, value) pair into
 * the HashMap. If the key already exists in the map, update the corresponding value. int get(int key) returns the value
 * to which the specified key is mapped, or -1 if this map contains no mapping for the key. void remove(key) removes the
 * key and its corresponding value if the map contains the mapping for the key.
 */
public class MyHashMap {

    int[] array;

    public MyHashMap() {
        array = new int[(int) 1e6 + 1];
        Arrays.fill(array, -1);
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        return array[key];
    }

    public void remove(int key) {
        array[key] = -1;
    }
}
