package com.sedykh.slow_fast_pointers;

/**
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the
 * list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's
 * next pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast!= null && fast.next != null) return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}

// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3...
// p - part from start up to start of cycle
// c - cycle length
// x - from start of cycle to meeting point of start and slow pointers
// steps fast  2 x
// steps slow   x
// x < distinct steps


// p + c - x = slow
// 2(p+c-x)=p+N*c-x
// p=x + N*c
//N*c can be thrown away
//p=x