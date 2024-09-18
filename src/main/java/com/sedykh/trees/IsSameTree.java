package com.sedykh.trees;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) return false;
        boolean leftEquals = dfs(p.left, q.left);
        boolean rightEquals = dfs(p.right, q.right);
        return leftEquals && rightEquals;
    }
}
