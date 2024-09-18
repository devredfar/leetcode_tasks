package com.sedykh.linked_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
    public static ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode root = new ListNode();
        var sortedNodes = new PriorityQueue<ListNode>(Comparator.comparing(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                sortedNodes.add(list);
            }
        }
        var node = root;
        while (!sortedNodes.isEmpty()) {
            node = addNext(sortedNodes, node);
        }
        return root.next;
    }

    private static ListNode addNext(PriorityQueue<ListNode> sortedNodes, ListNode node) {
        ListNode lowest = sortedNodes.poll();
        node.next = lowest;
        sortedNodes.remove(lowest);
        node = node.next;
        while (!sortedNodes.isEmpty() && node.next != null && (sortedNodes.peek().val >= node.next.val)) {
            node = node.next;
        }
        if (node.next != null) {
            sortedNodes.add(lowest.next);
        }
        return node;
    }

    public static ListNode mergeKListsWithListToManage(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        Collections.addAll(nodes, lists);
        nodes.add(new ListNode());
        while (nodes.size() > 1) {
            ListNode mergedNode = mergeTwoLists(nodes.get(0), nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(mergedNode);
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for (int i = 0; i < size - interval; i += 2 * interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return size > 0 ? lists[0] : null;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}
