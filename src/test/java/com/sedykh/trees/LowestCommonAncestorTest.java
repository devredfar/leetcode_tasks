package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

    @Test
    void lowestCommonAncestor() {
        TreeNode root = TreeNode.of(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = TreeNode.of(new Integer[]{2});
        TreeNode q = TreeNode.of(new Integer[]{8});
        var actualResult = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        Assertions.assertEquals(6, actualResult.val);
    }

    @Test
    void lowestCommonAncestor2() {
        TreeNode root = TreeNode.of(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = TreeNode.of(new Integer[]{2});
        TreeNode q = TreeNode.of(new Integer[]{4});
        var actualResult = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        Assertions.assertEquals(2, actualResult.val);
    }

    @Test
    void lowestCommonAncestor3() {
        TreeNode root = TreeNode.of(new Integer[]{2,1});
        TreeNode p = TreeNode.of(new Integer[]{2});
        TreeNode q = TreeNode.of(new Integer[]{1});
        var actualResult = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        Assertions.assertEquals(2, actualResult.val);
    }
}