package com.sedykh.trees;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        return isValidNode(root, null, null);
    }

    private static boolean isValidNode(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }
}

