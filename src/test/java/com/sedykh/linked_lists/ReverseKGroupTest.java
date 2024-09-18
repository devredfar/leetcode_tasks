package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseKGroupTest {
    @Test
    void reverseKGroup() {
        ListNode actualNode = ReverseKGroup.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2);
        Assertions.assertEquals(ListNode.of(2,1,4,3,5), actualNode);
    }

    @Test
    void reverseKGroup4() {
        ListNode actualNode = ReverseKGroup.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 5);
        Assertions.assertEquals(ListNode.of(5,4,3,2,1), actualNode);
    }

    @Test
    void reverseKGroup2() {
        ListNode actualNode = ReverseKGroup.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3);
        Assertions.assertEquals(ListNode.of(3,2,1,4,5), actualNode);
    }

    @Test
    void reverseKGroup3() {
        ListNode actualNode = ReverseKGroup.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 1);
        Assertions.assertEquals(ListNode.of(1,2,3,4,5), actualNode);
    }
}