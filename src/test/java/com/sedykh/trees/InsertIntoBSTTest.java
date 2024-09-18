package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertIntoBSTTest {

    @Test
    void insertIntoBST() {
        TreeNode treeNode = TreeNode.of(new Integer[]{4, 2, 7, 1, 3});
        TreeNode actualResult = InsertIntoBST.insertIntoBST(treeNode, 5);
        Assertions.assertEquals(TreeNode.of(new Integer[]{4,2,7,1,3,5}), actualResult);
    }
}