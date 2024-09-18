package com.sedykh.trees;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
 * in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaxPathSum {

    private int maxResult = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(dfs(root), maxResult);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int pathSumLeft = dfs(node.left);
        int pathSumRight = dfs(node.right);
        int maxPartOfPath = Math.max(pathSumRight, pathSumLeft);
        int currentPathSum =
                Math.max(
                        0,
                        Math.max(
                                pathSumLeft + pathSumRight,
                                maxPartOfPath))
                        + node.val;
        maxResult = Math.max(maxResult, currentPathSum);
        return Math.max(maxPartOfPath, 0) + node.val;
    }


    public int maxPathSumBetter(TreeNode root) {
        int[] res = { Integer.MIN_VALUE };
        maxPathSumBetter(root, res);
        return res[0];
    }

    public int maxPathSumBetter(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSumBetter(root.left, res));
        int right = Math.max(0, maxPathSumBetter(root.right, res));
        res[0] = Math.max(res[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
