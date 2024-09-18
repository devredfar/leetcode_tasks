package com.sedykh.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode treeNode = nodes.pollFirst();
            results.add(treeNode != null ? treeNode.val : null);
            if (treeNode != null) {
                nodes.add(treeNode.left);
                nodes.add(treeNode.right);
            }
        }

        var buffer = new StringBuilder();
        for (Integer value : results) {
            buffer.append(value != null ? value : "null");
            buffer.append(",");
        }
        return buffer.substring(0, buffer.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        TreeNode root;
        String[] split = data.split(",");
        List<Integer> list = new ArrayList<>(split.length);
        LinkedList<TreeNode> nodes = new LinkedList<>();
        for (String s : split) {
            list.add(s.equals("null") ? null : Integer.parseInt(s));
        }
        int maxLevel = findMaxLevel(list.size());
        if (list.isEmpty()) {
            return null;
        } else {
            Integer val = list.get(0);
            if (val == null){
                return null;
            }
            root = new TreeNode(val);
            nodes.add(root);
        }
        int levelStart = 1;
        for (int i = 1; i < maxLevel; i++) {
            int elemOnLevel = (int) Math.pow(2, i);
            int maxElemOnLevel = Math.min(list.size(), elemOnLevel + levelStart);
            TreeNode parent = null;
            for (int j = levelStart; j < maxElemOnLevel; j++) {
                if (j % 2 == 1) {
                    parent = nodes.pollFirst();
                }
                var val = list.get(j);
                if (val != null) {
                    TreeNode currentNode = new TreeNode(val);
                    if (j % 2 == 1) {
                        parent.left = currentNode;
                    } else {
                        parent.right = currentNode;
                    }
                    nodes.add(currentNode);
                }
            }
            levelStart += elemOnLevel;
        }
        return root;
    }

    private static int findMaxLevel(int size) {
        int b = 1;
        while (b < size) {
            b = b << 1;
        }
        return b;
    }


    // solution with DFS - easier

    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);

        return String.join(",", list);
    }

    private void serializeDFS(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDFS(root.left, list);
        serializeDFS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDFS(tokens);
    }

    private TreeNode deserializeDFS(String[] tokens) {
        String token = tokens[this.i];
        if (token.equals("N")) {
            this.i++;
            return null;
        }
        var node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDFS(tokens);
        node.right = deserializeDFS(tokens);
        return node;
    }
}
