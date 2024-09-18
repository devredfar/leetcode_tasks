package com.sedykh.hash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {

    /**
     * Input ["MyHashMap", "put", "put",   "get", "get", "put", "get", "remove", "get"] [[], [1, 1], [2, 2], [1], [3],
     * [2, 1], [2], [2], [2]] Output [null, null, null, 1, -1, null, 1, null, -1]
     */
    @Test
    public void test() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        int result1 = myHashMap.get(1);
        assertEquals(1, result1);
        int result2 = myHashMap.get(3);
        assertEquals(-1, result2);
        myHashMap.put(2, 1);
        int result3 = myHashMap.get(2);
        assertEquals(1, result3);
        myHashMap.remove(2);
        int result4 = myHashMap.get(2);
        assertEquals(-1, result4);
    }

}