package com.sedykh.linked_lists;

import java.util.HashSet;

public class HasCycle {

    public static boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        boolean noCycle = true;
        while (head != null && noCycle) {
            noCycle = set.add(head);
            head = head.next;
        }
        return !noCycle;
    }

    public static boolean hasCycle3(ListNode head) {
        boolean noCycle = true;
        while (head != null && noCycle) {
            noCycle = head.val < Integer.MAX_VALUE;
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return !noCycle;
    }

    public static boolean hasCycleMaxELem(ListNode head) {
        int count = 0;
        int maxElem = 10 ^ 4;
        boolean noCycle = true;
        while (head != null && noCycle) {
            count++;
            noCycle = count < maxElem;
            head = head.next;
        }
        return !noCycle;
    }

    public static boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null && !hasCycle) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
            }
        }
        return hasCycle;
    }
}
