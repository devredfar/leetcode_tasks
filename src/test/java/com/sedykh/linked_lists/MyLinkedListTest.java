package com.sedykh.linked_lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        assertEquals(2, myLinkedList.get(1));// return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        assertEquals(3, myLinkedList.get(1));// return 3
    }

//["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//        [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
//[null,null,null,null,null,null,null,null,4,null,null,null]
    @Test
    public void test2() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        assertEquals(4, myLinkedList.get(4));
    }

//    ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
//            [[],[0,10],[0,20],[1,30],[0]]
//[null,null,null,null,20]

    @Test
    public void test3() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0,10);
        myLinkedList.addAtIndex(0,20);
        myLinkedList.addAtIndex(1,30);
        assertEquals(20, myLinkedList.get(0));
    }
}