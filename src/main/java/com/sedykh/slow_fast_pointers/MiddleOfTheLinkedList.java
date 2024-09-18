package com.sedykh.slow_fast_pointers;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        var slowPointer = head;
        var fastPointer = head;
        while (fastPointer != null
                && fastPointer.next != null ) {
            if (fastPointer.next.next != null){
                fastPointer = fastPointer.next.next;
            } else {
                fastPointer = null;
            }
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }


}
