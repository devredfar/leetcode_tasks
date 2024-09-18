package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsValidBSTTest {

    @Test
    void isValidBST() {
        TreeNode treeNode = TreeNode.of(new Integer[]{2,1});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertTrue(actualResult);
    }
    @Test
    void isValidBST2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{2});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isValidBST3() {
        TreeNode treeNode = TreeNode.of(new Integer[]{2,1,3});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertTrue(actualResult);
    }

    @Test
    void isValidBST4() {
        TreeNode treeNode = TreeNode.of(new Integer[]{5,1,4,null,null,3,6});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertFalse(actualResult);
    }

    @Test
    void isValidBST5() {
        TreeNode treeNode = TreeNode.of(new Integer[]{5,4,6,null,null,3,7});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertFalse(actualResult);
    }

    @Test
    void isValidBST6() {
        TreeNode treeNode = TreeNode.of(new Integer[]{5,4,6,null,8,null,7});
        var actualResult = IsValidBST.isValidBST(treeNode);
        Assertions.assertFalse(actualResult);
    }
}