package com.sedykh.linked_lists;

import java.util.HashMap;

public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        var current = head;
        var newRoot = new Node(0);
        var newCurrent = newRoot;
        while (current != null) {
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            newCurrent.next = newNode;
            newCurrent = newNode;
            current = current.next;
        }
        current = head;
        newCurrent = newRoot.next;
        while (current != null) {
            newCurrent.random = map.get(current.random);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newRoot.next;
    }
}
