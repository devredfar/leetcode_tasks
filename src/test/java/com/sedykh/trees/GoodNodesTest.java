package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoodNodesTest {

    @Test
    void goodNodes() {
        TreeNode treeNode = TreeNode.of(new Integer[]{3, 1, 4, 3, null, 1, 5});
        int actualResult = new GoodNodes().goodNodes(treeNode);
        Assertions.assertEquals(4, actualResult);
    }
}