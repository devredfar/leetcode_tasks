package com.sedykh.slow_fast_pointers;

import java.util.Stack;

public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        int result = 0;
        ListNode reversedList = reverse(slowPointer);
        var notReversedList = head;
        while (reversedList != null) {
            var newResult = reversedList.val + notReversedList.val;
            result = Math.max(newResult, result);
            reversedList = reversedList.next;
            notReversedList = notReversedList.next;
        }
        return result;
    }
    public int pairSumWithStack(ListNode head) {
        if (head == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            stack.push(slowPointer.val);
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        int result = 0;
        while (slowPointer != null) {
            var newResult = slowPointer.val + stack.pop();
            result = Math.max(newResult, result);
            slowPointer = slowPointer.next;
        }
        return result;
    }

    public static ListNode reverse(ListNode root) {
        if (root == null){
            return null;
        }
        ListNode prev = root;
        if (prev.next == null){
            return prev;
        }
        ListNode current = prev.next;
        prev.next = null;
        while (current != null) {
            var temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}


// 1 -> 2 -> 3 -> 4
// 1 <- 2    3 -> 4

// prev current next
//        prev current next
//              prev current next