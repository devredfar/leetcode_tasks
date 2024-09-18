package com.sedykh.linked_lists;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode current) {
        ListNode previous = null;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static ListNode reverseListRecursive(ListNode current, ListNode previous) {
        if (current == null) return previous;
        var next = current.next;
        current.next = previous;
        return reverseListRecursive(next, current);
    }
}
