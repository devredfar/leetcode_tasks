package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

    @Test
    void diameterOfBinaryTree() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, 4, 5});
        int actualResult = DiameterOfBinaryTree.diameterOfBinaryTree(treeNode);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    void diameterOfBinaryTree2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2});
        int actualResult = DiameterOfBinaryTree.diameterOfBinaryTree(treeNode);
        Assertions.assertEquals(1, actualResult);
    }

    @Test
    void diameterOfBinaryTree3() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1});
        int actualResult = DiameterOfBinaryTree.diameterOfBinaryTree(treeNode);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    void diameterOfBinaryTree4() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, null, 3});
        int actualResult = DiameterOfBinaryTree.diameterOfBinaryTree(treeNode);
        Assertions.assertEquals(2, actualResult);
    }

    @Test
    void diameterOfBinaryTree5() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, 4});
        int actualResult = DiameterOfBinaryTree.diameterOfBinaryTree(treeNode);
        Assertions.assertEquals(3, actualResult);
    }
}