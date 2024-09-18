package com.sedykh.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallest {

    List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> integers = inorderTraversal(root, k);
        return integers.get(k -1);
    }

    public List<Integer> inorderTraversal(TreeNode root, int k) {
        if (root != null && result.size() <= k) {
            inorderTraversal(root.left, k);
            result.add(root.val);
            inorderTraversal(root.right, k);
        }
        return result;
    }


    public int kthSmallest2(TreeNode root, int k) {
        int[] num = new int[]{0};
        int[] result2 = new int[]{0};
        return inorderTraversal(root, k, num, result2);
    }

    public static int inorderTraversal(TreeNode root, int k, int[] num, int[] result2) {
        if (root != null ) {
            inorderTraversal(root.left, k, num, result2);
            num[0]++;
            if (num[0] <= k) {
                result2[0] = root.val;
            }
            inorderTraversal(root.right, k, num, result2);
        }
        return result2[0];
    }
}
