package com.sedykh.linked_lists;

public class BrowserHistory {
    ListNode current;

    public BrowserHistory(String homepage) {
        this.current = new ListNode(homepage);
    }

    public void visit(String url) {
        ListNode newUrl = new ListNode(url);
        current.next = newUrl;
        newUrl.prev = current;
        current = newUrl;
    }

    public String back(int steps) {
        while (current.prev != null && steps > 0) {
            current = current.prev;
            steps -= 1;
        }
        return current.val;
    }

    public String forward(int steps) {
        while (current.next != null && steps > 0) {
            current = current.next;
            steps -= 1;
        }
        return current.val;
    }

    static class ListNode {
        String val;
        ListNode prev;
        ListNode next;

        public ListNode(String val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
