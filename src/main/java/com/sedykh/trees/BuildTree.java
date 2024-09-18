package com.sedykh.trees;

import java.util.Arrays;

/**
 * Given two integer arrays preorder and inorder where
 * preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) mid = i;
        }

        root.left =
                buildTree(
                        Arrays.copyOfRange(preorder, 1, mid + 1),
                        Arrays.copyOfRange(inorder, 0, mid)
                );
        root.right =
                buildTree(
                        Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                        Arrays.copyOfRange(inorder, mid + 1, inorder.length)
                );

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int startingIndex) {
        if (startingIndex >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startingIndex]);
        var node = root;

        int index = findIndex(preorder, inorder[startingIndex]);
        for (int i = startingIndex + 1; i < index + 1; i++) {
            node.left = new TreeNode(preorder[i]);
            node = node.left;
        }
        root.right = buildTree(preorder, inorder, index + 1);
        return root;
    }


    private int findIndex(int[] inorder, int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
