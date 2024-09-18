package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.sedykh.linked_lists.MergeTwoLists.mergeTwoLists;

class MergeTwoListsTest {

    @Test
    void reverseList() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        ListNode actualReversedList = mergeTwoLists(listNode, listNode2);
        Assertions.assertEquals(actualReversedList, new ListNode(1, new ListNode(2)));
    }

    @Test
    void reverseList2() {
        ListNode listNode = new ListNode(1, new ListNode(3));
        ListNode listNode2 = new ListNode(2);

        ListNode actualReversedList = mergeTwoLists(listNode, listNode2);
        Assertions.assertEquals(actualReversedList, new ListNode(1, new ListNode(2, new ListNode(3))));
    }


}