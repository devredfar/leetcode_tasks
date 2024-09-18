package com.sedykh.linked_lists;


public class MergeTwoLists {

    public static ListNode mergeTwoLists4(ListNode list1, ListNode list2) {
        final ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return root.next;
    }

    public static ListNode mergeTwoLists(ListNode n1 , ListNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        ListNode temp1 = n1;
        ListNode temp2 = n2;

        ListNode curr = new ListNode(0);

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                curr.next = temp1;
                temp1 = temp1.next;
            }
            else {
                curr.next = temp2;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }

        if(temp1 != null) curr.next = temp1;
        if(temp2 != null) curr.next = temp2;

        return n1.val <= n2.val ? n1 : n2;
    }

    public static ListNode mergeTwoListsWithRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        return reverseList(merge2(list1, list2, null));
    }

    public static ListNode merge2(ListNode list1, ListNode list2, ListNode tail) {
        if (list1 == null && list2 == null) {
            return tail;
        }
        if (list1 == null) {
            return merge2(list2.next, null, new ListNode(list2.val, tail));
        }
        if (list2 == null) {
            return merge2(list1.next, null, new ListNode(list1.val, tail));
        }
        if (list1.val > list2.val) {
            return merge2(list1, list2.next, new ListNode(list2.val, tail));
        } else {
            return merge2(list1.next, list2, new ListNode(list1.val, tail));
        }
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private static ListNode reverseList(ListNode current, ListNode previous) {
        if (current == null) return previous;
        var next = current.next;
        current.next = previous;
        return reverseList(next, current);
    }
}