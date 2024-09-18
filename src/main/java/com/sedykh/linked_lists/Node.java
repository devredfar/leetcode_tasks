package com.sedykh.linked_lists;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    Node next;
    Node random;

    @Override
    public String toString() {
        var rnd = random != null ? random.val : "null";
        return val + "->" + rnd + ", " + next;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node of(List<Integer> list, List<String> connections) {
        ArrayList<Node> nodes = new ArrayList<>();
        var root = new Node(0);
        var prev = root;
        for (Integer integer : list) {
            Node node = new Node(integer);
            prev.next = node;
            prev = node;
            nodes.add(node);
        }
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i) != null && !connections.get(i).equals("null")) {
                int rndNode = Integer.parseInt(connections.get(i));
                Node node = nodes.get(i);
                node.random = nodes.get(rndNode);
            }
        }

        return root.next;
    }
}
