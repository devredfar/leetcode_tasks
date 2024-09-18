package com.sedykh.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeKListsTest {

    @Test
    void mergeKLists() {
//        lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
        ListNode actualResult = MergeKLists.mergeKLists(new ListNode[]{
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6)});
        Assertions.assertEquals(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6), actualResult);
    }


    @Test
    void mergeKLists2() {
        ListNode actualResult = MergeKLists.mergeKLists(new ListNode[]{
                ListNode.of(1, 1, 1),
                ListNode.of(2, 2, 2)});
        Assertions.assertEquals(ListNode.of(1, 1, 1, 2, 2, 2), actualResult);
    }

//    [[1,2,2],[1,1,2]]

    @Test
    void mergeKLists3() {
        ListNode actualResult = MergeKLists.mergeKLists(new ListNode[]{
                ListNode.of(1, 2, 2),
                ListNode.of(1, 1, 2)});
        Assertions.assertEquals(ListNode.of(1, 1, 1, 2, 2, 2), actualResult);
    }
}