package com.sedykh.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        stack.push(root);
        visited.push(false);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            boolean visitedNode = visited.pop();
            if (visitedNode) {
                result.add(node.val);
            } else {
                stack.push(node);
                visited.push(true);
                if (node.right != null) {
                    stack.push(node.right);
                    visited.push(false);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    visited.push(false);
                }
            }
        }
        return result;
    }
}
