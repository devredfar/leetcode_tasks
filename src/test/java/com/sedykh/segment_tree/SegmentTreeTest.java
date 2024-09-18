package com.sedykh.segment_tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {

    @Test
    public void test() {
        SegmentTree segmentTree = new SegmentTree(new int[]{1, 2, 3, 4, 5});
        assertEquals(6, segmentTree.query(0, 2));
        assertEquals(12, segmentTree.query(2, 4));
        segmentTree.update(3, 0);
        assertEquals(8, segmentTree.query(2, 4));
    }
}