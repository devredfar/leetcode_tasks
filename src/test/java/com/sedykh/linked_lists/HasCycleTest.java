package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HasCycleTest {

    @Test
    void hasCycle() {
        var expectedResult = true;
        ListNode listNode = ListNode.of(3, 2, 0, -4);
        listNode.next.next.next.next = listNode.next;
        boolean actualResult = HasCycle.hasCycle(listNode);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}