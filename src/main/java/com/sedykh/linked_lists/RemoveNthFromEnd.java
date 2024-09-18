package com.sedykh.linked_lists;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        var root = new ListNode(0, head);
        var slow = head;
        var fast = head;
        int diff = 0;
        do {
            fast = fast.next;
            diff++;
        } while (diff < n);

        var prev = root;

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return root.next;
    }
}
