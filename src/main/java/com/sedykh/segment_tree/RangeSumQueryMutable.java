package com.sedykh.segment_tree;

/**
 * Given an integer array nums, handle multiple queries of the following types:
 * <p>
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQueryMutable {
    class NumArray {

        private final Node root;

        public NumArray(int[] nums) {
            root = Node.build(nums, 0, nums.length - 1);
        }

        public void update(int index, int val) {
            root.update(index, val);
        }

        public int sumRange(int left, int right) {
            return root.query(left, right);
        }

        private static class Node {
            int sum;
            int l;
            int r;
            Node left;
            Node right;

            public Node(int sum, int l, int r, Node left, Node right) {
                this.sum = sum;
                this.l = l;
                this.r = r;
                this.left = left;
                this.right = right;
            }

            public static Node build(int[] nums, int l, int r) {
                if (l == r) {
                    return new Node(nums[l], l, r, null, null);
                }
                var m = (l + r) / 2;
                var leftNode = build(nums, l, m);
                var rightNode = build(nums, m + 1, r);
                return new Node(leftNode.sum + rightNode.sum, l, r, leftNode, rightNode);
            }

            public void update(int index, int val) {
                if (this.l == this.r) {
                    sum = val;
                } else {
                    var m = (l + r) / 2;
                    if (index <= m) {
                        this.left.update(index, val);
                    } else {
                        this.right.update(index, val);
                    }
                    this.sum = this.left.sum + this.right.sum;
                }
            }

            public int query(int left, int right) {
                if (left == this.l && right == this.r) {
                    return this.sum;
                }
                var m = (l + r) / 2;
                if (right <= m) {
                    return this.left.query(left, right);
                } else if (left > m) {
                    return this.right.query(left, right);
                }
                return this.left.query(left, m) + this.right.query(m + 1, right);
            }
        }
    }
}
