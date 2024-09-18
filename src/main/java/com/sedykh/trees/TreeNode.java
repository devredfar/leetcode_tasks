package com.sedykh.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "{val=" + val +
                ", left=" + left +
                ", right=" + right + "}";
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer[] values) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        treeNodes.add(root);
        for (int i = 1; i < values.length; ) {
            TreeNode treeNode = treeNodes.poll();
            Integer leftValue = values[i];
            var leftNode = leftValue != null ? new TreeNode(leftValue) : null;
            treeNode.left = leftNode;
            treeNodes.add(leftNode);
            if (i + 1 < values.length) {
                Integer rightValue = values[i + 1];
                var rightNode = rightValue != null ? new TreeNode(rightValue) : null;
                treeNode.right = rightNode;
                treeNodes.add(rightNode);

            }
            i += 2;
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}