package com.sedykh.linked_lists;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int accum = 0;
        while (accum != 0 || l1 != null || l2 != null) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sum = accum + l1val + l2val;
            accum = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root.next;
    }
}
