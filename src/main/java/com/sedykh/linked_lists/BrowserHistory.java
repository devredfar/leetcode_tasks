package com.sedykh.linked_lists;

/**
 * 1472. Design Browser History
 * <p>
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 * Implement the BrowserHistory class:
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history
 * and steps > x,
 * you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in
 * the history and steps > x, you will forward only x steps. Return the current url after
 * forwarding in history at most steps.
 * <p>
 * Constraints:
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 */
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
