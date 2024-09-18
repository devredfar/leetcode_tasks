package com.sedykh.segment_tree;

public class SegmentTree {

    int sum;
    int l;
    int r;
    SegmentTree left;
    SegmentTree right;

    public SegmentTree(int[] nums) {
        SegmentTree build = build(nums, 0, nums.length - 1);
        this.l =build.l;
        this.r =build.r;
        this.sum =build.sum;
        this.left =build.left;
        this.right =build.right;
    }

    public SegmentTree(int sum, int l, int r) {
        this.sum = sum;
        this.l = l;
        this.r = r;
    }

    public SegmentTree(int sum,
                       int l,
                       int r,
                       SegmentTree left,
                       SegmentTree right) {
        this.sum = sum;
        this.l = l;
        this.r = r;
        this.left = left;
        this.right = right;
    }

    private static SegmentTree build(int[] nums, int l, int r) {
        if (l == r) {
            return new SegmentTree(nums[l], l, r);
        }
        var m = (r + l) / 2;
        var leftTree = build(nums, l, m);
        var rightTree = build(nums, m + 1, r);
        var sum = leftTree.sum + rightTree.sum;
        return new SegmentTree(sum, l, r, leftTree, rightTree);
    }


    public void update(int index, int val) {
        if (this.l == this.r) {
            this.sum = val;
        } else {
            var m = (this.l + this.r) / 2;
            if (index <= m) {
                this.left.update(index, val);
            } else {
                this.right.update(index, val);
            }
            this.sum = this.left.sum + this.right.sum;
        }
    }

    public int query(int L, int R) {
        if (L == this.l && R == this.r) {
            return this.sum;
        } else {
            var m = (this.l + this.r) / 2;
            if (L > m) {
                return this.right.query(L, R);
            }
            if (R <= m) {
                return this.left.query(L, R);
            }
            return this.left.query(L, m) + this.right.query(m + 1, R);
        }
    }
}
