package com.sedykh.linked_lists;

import java.util.HashMap;

/**
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer
 * points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * Constraints:
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */
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
