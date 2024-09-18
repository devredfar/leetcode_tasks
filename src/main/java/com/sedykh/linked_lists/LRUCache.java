package com.sedykh.linked_lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    Map<Integer, Node> map;
    Node lruNode;
    Node mruNode;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node == mruNode) {
            return node.value;
        }
        cutNodeFromList(node);
        removeNodeFromLru(node);
        setNodeAsNewMru(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node newNode;
        if (map.containsKey(key)) {
            newNode = map.get(key);
            newNode.value = value;
            if (newNode != mruNode) {
                cutNodeFromList(newNode);
                removeNodeFromLru(newNode);
            }
        } else {
            newNode = new Node(key, value, null, null);
            if (map.isEmpty()) {
                lruNode = newNode;
                mruNode = newNode;
            }
        }
        if (newNode != mruNode) {
            setNodeAsNewMru(newNode);
        }
        map.put(key, newNode);
        removeLruNodeIfCapacityExtended();
    }

    private void removeLruNodeIfCapacityExtended() {
        if (map.size() > capacity) {
            map.remove(lruNode.key);
            Node nextNode = lruNode.next;
            nextNode.previous = null;
            lruNode = nextNode;
        }
    }

    private static void cutNodeFromList(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.previous;
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.previous = prevNode;
        }
    }

    private void removeNodeFromLru(Node node) {
        if (node == lruNode && lruNode.next != null) {
            lruNode = lruNode.next;
            lruNode.previous = null;
        }
    }

    private void setNodeAsNewMru(Node newNode) {
        mruNode.next = newNode;
        newNode.previous = mruNode;
        mruNode = newNode;
        mruNode.next = null;
    }

    static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value, Node previous, Node next) {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key && value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "(" + key +
                    "," + value +
                    ")->" + previous;
        }
    }
}
