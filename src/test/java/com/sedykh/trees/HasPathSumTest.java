package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HasPathSumTest {

    @Test
    void hasPathSum() {
        TreeNode root = TreeNode.of(new Integer[]{-2, null, -3});
        boolean result = HasPathSum.hasPathSum(root, -5);
        Assertions.assertTrue(result);
    }
}