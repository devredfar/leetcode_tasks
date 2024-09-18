package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteNodeTest {

    @Test
    void deleteNode4() {
        TreeNode treeNode = TreeNode.of(new Integer[]{2,1});
        TreeNode actualResult = DeleteNode.deleteNode(treeNode, 2);
        Assertions.assertEquals(TreeNode.of(new Integer[]{1}), actualResult);
    }
    @Test
    void deleteNode() {
        TreeNode treeNode = TreeNode.of(new Integer[]{5,3,6,2,4,null,7});
        TreeNode actualResult = DeleteNode.deleteNode(treeNode, 3);
        Assertions.assertEquals(TreeNode.of(new Integer[]{5,4,6,2,null,null,7}), actualResult);
    }

    @Test
    void deleteNode3() {
        TreeNode treeNode = TreeNode.of(new Integer[]{5,3,6,2,4,null,7});
        TreeNode actualResult = DeleteNode.deleteNode(treeNode, 7);
        Assertions.assertEquals(TreeNode.of(new Integer[]{5,3,6,2,4}), actualResult);
    }

    @Test
    void deleteNode2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{0});
        TreeNode actualResult = DeleteNode.deleteNode(treeNode, 0);
        Assertions.assertNull(actualResult);
    }
}