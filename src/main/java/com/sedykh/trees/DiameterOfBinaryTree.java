package com.sedykh.trees;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxResult = new int[]{0}; //can class variable if remove static from method calls
        diameter(root, maxResult);
        return maxResult[0];
    }

    public static int diameter(TreeNode node, int[] maxResult) {
        if (node == null) {
            return 0;
        }
        int diameterLeft = diameter(node.left, maxResult);
        int diameterRight = diameter(node.right, maxResult);
        int currentResult = diameterLeft + diameterRight;
        maxResult[0] = Math.max(maxResult[0], currentResult);
        return Math.max(diameterLeft, diameterRight) + 1;
    }
}
