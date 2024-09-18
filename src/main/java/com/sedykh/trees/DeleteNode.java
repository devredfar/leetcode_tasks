package com.sedykh.trees;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class DeleteNode {

    public static TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeInternal(root, key);
    }

    public static TreeNode deleteNodeInternal(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val > key) {
            node.left = deleteNodeInternal(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNodeInternal(node.right, key);
            return node;
        }

        if (node.right == null) {
            return node.left;
        }

        if (node.left == null) {
            return node.right;
        }

        node.val = findMinNodeValue(node.right);
        node.right = deleteNodeInternal(node.right, node.val);

        return node;
    }

    public static int findMinNodeValue(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
