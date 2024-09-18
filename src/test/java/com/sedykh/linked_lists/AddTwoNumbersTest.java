package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        ListNode actualNodes = AddTwoNumbers.addTwoNumbers(
                ListNode.of(2, 4, 3),
                ListNode.of(5, 6, 4));
        Assertions.assertEquals(ListNode.of(7, 0, 8), actualNodes);
    }

    @Test
    void addTwoNumbers2() {
        ListNode actualNodes = AddTwoNumbers.addTwoNumbers(
                ListNode.of(0),
                ListNode.of(0));
        Assertions.assertEquals(ListNode.of(0), actualNodes);
    }

    @Test
    void addTwoNumbers3() {
        ListNode actualNodes = AddTwoNumbers.addTwoNumbers(
                ListNode.of(9,9,9,9,9,9,9),
                ListNode.of(9,9,9,9));
        Assertions.assertEquals(ListNode.of(8,9,9,9,0,0,0,1), actualNodes);
    }
}