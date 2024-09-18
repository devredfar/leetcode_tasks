package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        ListNode listNode = new ListNode(1);

        ListNode actualReversedList = ReverseLinkedList.reverseList(listNode);
        Assertions.assertEquals(actualReversedList, new ListNode(1));
    }

    @Test
    void reverseList2() {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode = new ListNode(1, listNode2);

        ListNode actualReversedList = ReverseLinkedList.reverseList(listNode);
        ListNode expectedReversedList = new ListNode(2, new ListNode(1));
        Assertions.assertEquals(expectedReversedList, actualReversedList);
    }

    @Test
    void reverseList3() {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode = new ListNode(1, listNode2);

        ListNode actualReversedList = ReverseLinkedList.reverseList(listNode);
        ListNode expectedReversedList = new ListNode(3, new ListNode(2, new ListNode(1)));
        Assertions.assertEquals(expectedReversedList, actualReversedList);
    }


    @Test
    void reverseList4() {
        ListNode actualReversedList = ReverseLinkedList.reverseList(ListNode.of(1, 2, 3, 4, 5, 6, 7));
        ListNode expectedReversedList = ListNode.of(7, 6, 5, 4, 3, 2, 1);
        Assertions.assertEquals(expectedReversedList, actualReversedList);
    }
}