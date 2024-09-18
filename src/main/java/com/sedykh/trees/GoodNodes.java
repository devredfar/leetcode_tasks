package com.sedykh.trees;

/**
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */
public class GoodNodes {

    private int result = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return result;
    }

    private void dfs(TreeNode node, int maxValue) {
        if (node == null) return;
        int newMaxValue = maxValue;
        if (node.val >= maxValue) {
            result++;
            newMaxValue = node.val;

        }
        dfs(node.left, newMaxValue);
        dfs(node.right, newMaxValue);
    }
}
