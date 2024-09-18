package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsBalancedTest {

    @Test
    void isBalanced() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1});
        var actualResult = new IsBalanced().isBalanced(treeNode);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isBalanced2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1,2});
        var actualResult = new IsBalanced().isBalanced(treeNode);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isBalanced3() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1,2,3});
        var actualResult = new IsBalanced().isBalanced(treeNode);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isBalanced4() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1,2, null,3});
        var actualResult = new IsBalanced().isBalanced(treeNode);
        Assertions.assertFalse(actualResult);
    }

}