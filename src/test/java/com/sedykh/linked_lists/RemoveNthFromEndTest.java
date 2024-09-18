package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveNthFromEndTest {

    @Test
    void removeNthFromEnd() {
        ListNode listNode = ListNode.of(1, 2, 3, 4, 5);
        ListNode expectedListNode = ListNode.of(1, 2, 3, 5);
        var actualListNode = RemoveNthFromEnd.removeNthFromEnd(listNode, 2);
        Assertions.assertEquals(expectedListNode, actualListNode);
    }

    @Test
    void removeNthFromEnd2() {
        ListNode listNode = ListNode.of(1);
        ListNode expectedListNode = ListNode.of();
        ListNode actualListNode = RemoveNthFromEnd.removeNthFromEnd(listNode, 1);
        Assertions.assertEquals(expectedListNode, actualListNode);
    }

    @Test
    void removeNthFromEnd3() {
        ListNode listNode = ListNode.of(1,2);
        ListNode expectedListNode = ListNode.of(1);
        ListNode actualListNode = RemoveNthFromEnd.removeNthFromEnd(listNode, 1);
        Assertions.assertEquals(expectedListNode, actualListNode);
    }

    @Test
    void removeNthFromEnd4() {
        ListNode listNode = ListNode.of(1,2);
        ListNode expectedListNode = ListNode.of(2);
        ListNode actualListNode = RemoveNthFromEnd.removeNthFromEnd(listNode, 2);
        Assertions.assertEquals(expectedListNode, actualListNode);
    }
}