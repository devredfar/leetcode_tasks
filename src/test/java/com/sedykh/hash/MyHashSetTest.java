package com.sedykh.hash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyHashSetTest {

    @Test
    void add() {
        MyHashSet set = new MyHashSet();
        assertFalse(set.contains(72));
        set.remove(91);
        set.add(48);
        set.add(41);
        assertFalse(set.contains(96));
    }
}