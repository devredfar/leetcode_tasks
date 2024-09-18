package com.sedykh.graphs;


import java.util.HashMap;
import java.util.Map;

/**
 * 133. Clone Graph Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> nodes = new HashMap<>();
        return makeDeepCopy(node, nodes);
    }

    private static Node makeDeepCopy(Node node, Map<Integer, Node> nodes) {
        Node newNode = nodes.get(node.val);
        if (newNode != null) {
            return newNode;
        }
        newNode = new Node(node.val);
        nodes.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(makeDeepCopy(neighbor, nodes));
        }
        return newNode;
    }
}
