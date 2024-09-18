package com.sedykh.queue;

/***
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively.
 * All students stand in a queue. Each student either prefers square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 *
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 *
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th
 * sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th
 * student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 */
public class CountStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack sandwichesStack = new Stack();
        Queue studentsQueue = new Queue();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichesStack.push(sandwiches[i]);
            studentsQueue.addTop(students[i]);
        }

        boolean somethingChanged = true;

        while ((!studentsQueue.isEmpty()
                && !sandwichesStack.isEmpty())
                && somethingChanged) {
            int changed = 0;
            int studentSize = studentsQueue.getSize();
            for (int i = 0; i < studentSize; i++) {
                Node topStudent = studentsQueue.getTop();
                Node topSandwich = sandwichesStack.peek();
                if (topStudent.val == topSandwich.val) {
                    studentsQueue.popTop();
                    sandwichesStack.pop();
                } else {
                    studentsQueue.popTop();
                    studentsQueue.addBottom(topStudent.val);
                    changed++;
                }
            }
            if (changed == studentSize) {
                somethingChanged = false;
            }
        }
        return studentsQueue.getSize();
    }

    class Stack {
        private Node top;

        public Stack() {
        }

        public void push(int val) {
            Node newNode = new Node(val);
            if (top == null) {
                top = newNode;
            } else {
                newNode.prev = top;
                top.next = newNode;
                top = newNode;
            }
        }

        public Node pop() {
            if (top == null) {
                return null;
            } else {
                Node result = top;
                top = top.prev;
                return result;
            }
        }

        public Node peek() {
            return top;
        }

        public boolean isEmpty() {
            return top == null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            var current = top;
            while (current != null) {
                sb.append(current.val);
                current = current.prev;
                if (current != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    class Queue {

        public int size;
        private Node top;
        private Node bottom;

        public Queue() {
        }

        public void addTop(int val) {
            Node newNode = new Node(val);
            size++;
            if (top == null) {
                top = newNode;
                bottom = newNode;
            } else {
                newNode.prev = top;
                top.next = newNode;
                top = newNode;
            }
        }

        public void addBottom(int val) {
            size++;
            Node newNode = new Node(val);
            if (bottom == null) {
                top = newNode;
                bottom = newNode;
            } else {
                newNode.next = bottom;
                bottom.prev = newNode;
                bottom = newNode;
            }
        }

        public Node getTop() {
            return top;
        }

        public Node getBottom() {
            return bottom;
        }

        public Node popTop() {
            var result = top;
            if (top != null) {
                top = top.prev;
                size--;
            }
            return result;
        }

        public Node popBottom() {
            var result = bottom;
            if (bottom != null) {
                bottom = bottom.next;
                size--;
            }
            return result;
        }

        public boolean isEmpty() {
            return top == null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            var current = top;
            while (current != null) {
                sb.append(current.val);
                current = current.prev;
                if (current != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public int getSize() {
            return size;
        }
    }

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
