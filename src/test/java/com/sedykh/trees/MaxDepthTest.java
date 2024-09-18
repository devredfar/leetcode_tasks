package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxDepthTest {

    @Test
    public void maxDepth1() {
        TreeNode treeNode = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        int actualResult = MaxDepth.maxDepth(treeNode);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    public void maxDepth2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, null, 2});
        int actualResult = MaxDepth.maxDepth(treeNode);
        Assertions.assertEquals(2, actualResult);
    }
}