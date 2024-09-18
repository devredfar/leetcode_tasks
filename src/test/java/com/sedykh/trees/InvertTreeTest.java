package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvertTreeTest {

    @Test
    void invertTree() {
        //given
        TreeNode treeNode = TreeNode.of(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode expectedResult = TreeNode.of(new Integer[]{4,7,2,9,6,3,1});
        //when
        TreeNode actualResult = InvertTree.invertTree(treeNode);
        //then
        Assertions.assertEquals(actualResult,expectedResult);
    }

    @Test
    void invertTreeRecursive() {
        //given
        TreeNode treeNode = TreeNode.of(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode expectedResult = TreeNode.of(new Integer[]{4,7,2,9,6,3,1});
        //when
        TreeNode actualResult = InvertTree.invertTreeRecursive(treeNode);
        //then
        Assertions.assertEquals(actualResult,expectedResult);
    }

    @Test
    void invertTreeRecursiveExample() {
        //given
        TreeNode treeNode = TreeNode.of(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode expectedResult = TreeNode.of(new Integer[]{4,7,2,9,6,3,1});
        //when
        TreeNode actualResult = InvertTree.invertTreeRecursiveExample(treeNode);
        //then
        Assertions.assertEquals(actualResult,expectedResult);
    }
}