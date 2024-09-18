package com.sedykh.trees;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return
 * the subtree rooted with that node. If such a node does not exist, return null.
 */
public class SearchBST {
    public static TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) return null;
        if (val > root.val) {
            return searchBSTRecursive(root.right, val);
        }
        if (val < root.val) {
            return searchBSTRecursive(root.left, val);
        }
        return root;
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode answerNode = null;
        while (root != null && answerNode == null) {
            if (val > root.val) {
                root = root.right;
            } else if (val < root.val) {
                root = root.left;
            } else {
                answerNode = root;
            }
        }
        return answerNode;
    }
}
