package com.sedykh.trees;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implement the BSTIterator class that represents an iterator over the
 * in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor.
 * The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
 * otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid.
 * That is, there will be at least a next number in the in-order traversal when next() is called.
 */
public class BinarySearchTreeIterator {
    public static class BSTIterator {

        private final LinkedList<Integer> resultStack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            var current = root;
            Stack<TreeNode> stack = new Stack<>();
            while (current != null || !stack.empty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    resultStack.push(current.val);
                    current = current.right;
                }
            }
        }

        public int next() {
            return resultStack.pollLast();
        }

        public boolean hasNext() {
            return !resultStack.isEmpty();
        }
    }
}
