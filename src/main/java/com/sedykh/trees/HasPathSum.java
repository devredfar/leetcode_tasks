package com.sedykh.trees;

/**
 * 112. Path Sum Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 */
public class HasPathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int diff = targetSum - root.val;
        if (diff == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean b = hasPathSum(root.left, diff);
        return b || hasPathSum(root.right, diff);
    }
}