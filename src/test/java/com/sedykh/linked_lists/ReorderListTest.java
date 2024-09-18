package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReorderListTest {

    @Test
    void reorderList() {
        ListNode listNode = ListNode.of(1, 2, 3);
        ListNode expectedListNode = ListNode.of(1, 3, 2);
        ReorderList.reorderList(listNode);
        Assertions.assertEquals(expectedListNode, listNode);
    }

    @Test
    void reorderList3() {
        ListNode listNode = ListNode.of(1, 2, 3, 4);
        ListNode expectedListNode = ListNode.of(1, 4, 2, 3);
        ReorderList.reorderList(listNode);
        Assertions.assertEquals(expectedListNode, listNode);
    }


    @Test
    void reorderList2() {
        ListNode listNode = ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ListNode expectedListNode = ListNode.of(1, 9, 2, 8, 3, 7, 4, 6, 5);
        ReorderList.reorderList(listNode);
        Assertions.assertEquals(expectedListNode, listNode);
    }
}