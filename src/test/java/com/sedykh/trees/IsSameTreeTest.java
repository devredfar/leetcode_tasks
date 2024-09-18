package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsSameTreeTest {

    @Test
    void isSameTree() {
        TreeNode q = TreeNode.of(new Integer[]{1});
        TreeNode p = TreeNode.of(new Integer[]{1});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isSameTree2() {
        TreeNode q = TreeNode.of(new Integer[]{1, 2});
        TreeNode p = TreeNode.of(new Integer[]{1, 2});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isSameTree3() {
        TreeNode q = TreeNode.of(new Integer[]{1, 2, 3});
        TreeNode p = TreeNode.of(new Integer[]{1, 2, 3});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isSameTree4() {
        TreeNode q = TreeNode.of(new Integer[]{1, null, 2});
        TreeNode p = TreeNode.of(new Integer[]{1, null, 2});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isSameTree5() {
        TreeNode q = TreeNode.of(new Integer[]{1});
        TreeNode p = TreeNode.of(new Integer[]{2});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertFalse(actualResult);
    }

    @Test
    void isSameTree6() {
        TreeNode q = TreeNode.of(new Integer[]{1, 2});
        TreeNode p = TreeNode.of(new Integer[]{1, 3});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertFalse(actualResult);
    }

    @Test
    void isSameTree7() {
        TreeNode q = TreeNode.of(new Integer[]{1, 2});
        TreeNode p = TreeNode.of(new Integer[]{1, null, 2});
        var actualResult = new IsSameTree().isSameTree(p, q);
        Assertions.assertFalse(actualResult);
    }
}