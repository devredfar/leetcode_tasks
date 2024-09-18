package com.sedykh.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static Node from(List<List<Integer>> data) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 1; i < data.size() + 1; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 1; i < data.size() + 1; i++) {
            List<Integer> neighborIds = data.get(i - 1);
            Node currentNode = map.get(i);
            neighborIds.forEach(neighborId -> currentNode.neighbors.add(map.get(neighborId)));
        }
        return map.get(1);
    }

    @Override
    public boolean equals(Object o) {
        // Standard equals checks
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (val != node.val) return false;

        // Compare the values of the neighbors instead of the Node instances themselves
        List<Integer> neighborValues1 = this.neighbors.stream().map(n -> n.val).toList();
        List<Integer> neighborValues2 = node.neighbors.stream().map(n -> n.val).toList();

        return neighborValues1.equals(neighborValues2);
    }

    @Override
    public int hashCode() {
        // Hash on the node values, and the values of the neighbors
        List<Integer> neighborValues = this.neighbors.stream().map(n -> n.val).collect(Collectors.toList());

        return Objects.hash(this.val, neighborValues);
    }
}
