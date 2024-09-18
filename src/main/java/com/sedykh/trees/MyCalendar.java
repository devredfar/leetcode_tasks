package com.sedykh.trees;

/**
 * You are implementing a program to use as your calendar.
 * We can add a new event if adding the event will not cause a double booking.
 * <p>
 * A double booking happens when two events have some non-empty intersection
 * (i.e., some moment is common to both events.).
 * <p>
 * The event can be represented as a pair of integers start and end that represents
 * a booking on the half-open interval [start, end), the range of real numbers x such
 * that start <= x < end.
 * <p>
 * Implement the MyCalendar class:
 * <p>
 * MyCalendar() Initializes the calendar object.
 * boolean book(int start, int end) Returns true if the event can be added to the calendar
 * successfully without causing a double booking. Otherwise, return false and do not add
 * the event to the calendar.
 */
public class MyCalendar {

    private final Node root;

    public MyCalendar() {
        root = new Node(0, 0);
    }

    public boolean book(int start, int end) {
        return root.insert(start, end);
    }

    private static class Node {
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean insert(int start, int end) {
            if (start >= this.end) {
                if (right == null) {
                    right = new Node(start, end);
                    return true;
                } else {
                    return right.insert(start, end);
                }
            }
            if (end <= this.start) {
                if (left == null) {
                    left = new Node(start, end);
                    return true;
                } else {
                    return left.insert(start, end);
                }
            }
            return false;
        }
    }
}
