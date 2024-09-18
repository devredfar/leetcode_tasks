package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthSmallestTest {

    @Test
    void kthSmallest2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{3, 1, 4, null, 2});
        int i = new KthSmallest().kthSmallest2(treeNode, 1);
        Assertions.assertEquals(1, i);
    }
}