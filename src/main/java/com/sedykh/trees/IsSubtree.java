package com.sedykh.trees;

/**
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure
 * and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree is a tree that consists of a node in tree
 * and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) {
            return true;
        }
        if (root != null) {
            return isSubtree(root.left, subRoot)
                    || isSubtree(root.right, subRoot);
        }
        return false;
    }

    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (q == null && p == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }


    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (subRoot == null || isSameTree2(root, subRoot)) return true;
        if (root == null) return false;

        return isSubtree2(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
