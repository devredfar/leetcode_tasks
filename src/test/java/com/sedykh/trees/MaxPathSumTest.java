package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxPathSumTest {

    @Test
    void maxPathSum() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3});
        int i = new MaxPathSum().maxPathSum(treeNode);
        Assertions.assertEquals(6, i);
    }

    @Test
    void maxPathSum3() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1,-2,3});
        int i = new MaxPathSum().maxPathSum(treeNode);
        Assertions.assertEquals(4, i);
    }

    @Test
    void maxPathSum2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{-10,9,20,null,null,15,7});
        int i = new MaxPathSum().maxPathSum(treeNode);
        Assertions.assertEquals(42, i);
    }



    @Test
    void maxPathSum5() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, -1,-1,-1,-1});
        int i = new MaxPathSum().maxPathSum(treeNode);
        Assertions.assertEquals(6, i);
    }

    @Test
    void maxPathSum6() {
        TreeNode treeNode = TreeNode.of(new Integer[]{9,-6,3,null,null,null,-2});
        TreeNode root = new TreeNode(-1, null, treeNode);
        int i = new MaxPathSum().maxPathSum(root);
        Assertions.assertEquals(12, i);
    }

}