package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsSubtreeTest {

    @Test
    void isSubtree() {
        TreeNode q = TreeNode.of(new Integer[]{1});
        TreeNode p = TreeNode.of(new Integer[]{1});
        var actualResult = new IsSubtree().isSubtree(p, q);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isSubtree2() {
        TreeNode q = TreeNode.of(new Integer[]{1, 2, 3, 4, 5});
        TreeNode p = TreeNode.of(new Integer[]{2, 4, 5});
        var actualResult = new IsSubtree().isSubtree(p, q);
        Assertions.assertTrue(actualResult);
    }
}