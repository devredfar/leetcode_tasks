package com.sedykh.linked_lists;

import java.util.LinkedList;

/***
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {

    public void reorderListIdeal(ListNode head) {

        //Find middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half of the list using a tmp variable
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        //Re-assign the pointers to match the pattern
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    public static void reorderList2(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        var elem = head;
        while (elem != null) {
            var current = elem;
            elem = elem.next;
            current.next = null;
            queue.add(current);
        }
        var prev = queue.pop();
        int i = 1;
        while (!queue.isEmpty()) {
            if (i % 2 == 0) {
                prev.next = queue.pollFirst();
            } else {
                prev.next = queue.pollLast();
            }
            i++;
            prev = prev.next;
        }
    }

    public static void reorderList(ListNode head) {
        var reversedHead = reverseList(head);
//need to find here middle and revert second part
        var prev = head;
        var prevReversed = reversedHead;

        do {
            var nextReversed = prevReversed.next;
            var next = prev.next;

            prev.next = prevReversed;
            prevReversed.next = next;
            prevReversed = nextReversed;
            prev = next;

        } while (prev.val != prevReversed.val);
    }


    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private static ListNode reverseList(ListNode current, ListNode previous) {
        if (current == null) return previous;
        var next = current.next;
        current.next = previous;
        return reverseList(next, current);
    }
}
