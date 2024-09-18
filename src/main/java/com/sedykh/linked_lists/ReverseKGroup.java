package com.sedykh.linked_lists;

/***
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        var current = head;
        var root = new ListNode();
        var movingRoot = root;
        var isEnough = isEnough(current, k);
        while (current != null && isEnough) {
            Result result = reverseList(current, k);
            current = result.remained;
            movingRoot.next = result.reversed;
            movingRoot = result.tail;
            isEnough = isEnough(current, k);
            if (!isEnough) {
                movingRoot.next = result.remained;
            }
        }
        return root.next;
    }

    private static boolean isEnough(ListNode head, int k) {
        int size = 0;
        var current = head;
        while (current != null) {
            size++;
            current = current.next;
            if (size == k) {
                return true;
            }
        }
        return false;
    }

    private static Result reverseList(ListNode current, int lim) {
        ListNode previous = null;
        var count = 0;
        ListNode tail = current;
        while (current != null && count < lim) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        return new Result(previous, current, tail);
    }

    record Result(ListNode reversed, ListNode remained, ListNode tail) {
    }



    public ListNode reverseKGroupIdeal(ListNode head, int k) {
        ListNode newHead = getLastItem(head, k);
        if (newHead == null) {
            return head;
        }

        ListNode nextHead = newHead.next;
        reverse(head, k);

        ListNode lastItem = head;
        while(nextHead != null) {
            ListNode currHead = getLastItem(nextHead, k);

            //If can't reverse the next one
            if (currHead == null) {
                lastItem.next = nextHead;
                return newHead;
            }
            ListNode nextNextHead = currHead.next;
            reverse(nextHead, k);
            lastItem.next = currHead;
            lastItem = nextHead;
            nextHead = nextNextHead;
        }
        lastItem.next = null;

        return newHead;
    }

    private ListNode getLastItem(ListNode head, int k) {
        ListNode newHead = head;

        int count = 1;
        while (count < k && newHead != null) {
            newHead = newHead.next;
            count++;
        }

        return newHead;
    }

    private void reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode newHead = head;
        int count = 1;
        while (count < k && newHead != null) {
            ListNode next = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = next;
            count++;
        }
        newHead.next = prev;
    }
}

