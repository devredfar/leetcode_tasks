package com.sedykh.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class LevelOrder {

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderDFS(root ,res ,0);
        return res;
    }

    private void levelOrderDFS(TreeNode root ,List<List<Integer>> res ,int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        levelOrderDFS(root.left ,res ,level + 1);
        levelOrderDFS(root.right ,res ,level + 1);
    }

    public static List<List<Integer>> levelOrderOptimised(TreeNode root) {
        Queue<TreeNode> buffer = new LinkedList<>();
        var result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        buffer.add(root);
        while (!buffer.isEmpty()) {
            var size = buffer.size();
            var currentLevelResult = new ArrayList<Integer>();
            for (int i = 0; i <size; i++) {
                TreeNode node = buffer.poll();
                currentLevelResult.add(node.val);
                if (node.left != null) {
                    buffer.add(node.left);
                }
                if (node.right != null) {
                    buffer.add(node.right);
                }
            }
            result.add(currentLevelResult);
        }
        return result;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> currentLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        var result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        currentLevel.add(root);
        var currentLevelResult = new ArrayList<Integer>();

        while (!currentLevel.isEmpty()) {
            for (var node : currentLevel) {
                currentLevelResult.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
            result.add(currentLevelResult);
            currentLevelResult = new ArrayList<>();
        }
        return result;
    }
}
