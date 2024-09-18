package com.sedykh.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!= null){
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return root;
    }


    public static TreeNode invertTreeRecursive(TreeNode node) {
        if (node == null){
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        invertTreeRecursive(left);
        invertTreeRecursive(right);
        return node;
    }


    public static TreeNode invertTreeRecursiveExample(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTreeRecursiveExample(root.left);
        node.left = invertTreeRecursiveExample(root.right);
        return node;
    }
}
