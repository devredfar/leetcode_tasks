package com.sedykh.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class InorderTraversal {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;

        }
        var node = root;
        while (node != null || !queue.isEmpty()) {
            while (node != null) {
                queue.addFirst(node);
                node = node.left;
            }
            node = queue.poll();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
        return result;
    }
}