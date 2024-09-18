package com.sedykh.trees;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 */
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private static int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(
                maxDepth(node.left, depth + 1),
                maxDepth(node.right, depth + 1)
        );
    }
    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
