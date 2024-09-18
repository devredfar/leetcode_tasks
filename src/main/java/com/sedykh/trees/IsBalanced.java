package com.sedykh.trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * A height-balanced binary tree is a binary tree in which
 * the depth of the two subtrees of every node never differs by more than one.
 */
public class IsBalanced {

    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
