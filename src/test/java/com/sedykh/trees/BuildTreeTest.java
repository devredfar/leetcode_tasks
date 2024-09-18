package com.sedykh.trees;

import org.junit.jupiter.api.Test;

class BuildTreeTest {

    @Test
    void buildTree() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new BuildTree().buildTree(preorder, inorder);
//        System.out.println(treeNode);
    }

    @Test
    void buildTree2() {
        int[] preorder = new int[]{3, 2, 1};
        int[] inorder = new int[]{1, 2, 3};
        TreeNode treeNode = new BuildTree().buildTree(preorder, inorder);
//        System.out.println(treeNode);
    }
}