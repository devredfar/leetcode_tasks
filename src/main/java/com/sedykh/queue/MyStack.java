package com.sedykh.queue;

import java.util.LinkedList;

/***
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back,
 * peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue) as long as you use
 * only a queue's standard operations.
 * two fifo into one lifo
 */
public class MyStack {

    private LinkedList<Integer> workingQueue;
    private LinkedList<Integer> reserveQueue;

    public MyStack() {
        workingQueue = new LinkedList<>();
        reserveQueue = new LinkedList<>();
    }

    public void push(int x) {
        reserveQueue.add(x);
        while (!workingQueue.isEmpty()) {
            reserveQueue.add(workingQueue.pop());
        }
        var temp = workingQueue;
        workingQueue = reserveQueue;
        reserveQueue = temp;
    }

    public int pop() {
        return workingQueue.pop();
    }

    public int top() {
        return workingQueue.peek();
    }

    public boolean empty() {
        return workingQueue.isEmpty();
    }
}
