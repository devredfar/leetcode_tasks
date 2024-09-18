package com.sedykh.trees;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class InorderTraversalTest {

    @Test
    public void test5() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> integers = new InorderTraversal().preorderTraversal(treeNode);
        Assertions.assertEquals(List.of(4,2,5,1,6,3,7), integers);
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> integers = new InorderTraversal().inorderTraversal(treeNode);
        Assertions.assertEquals(List.of(4,2,5,1,6,3,7), integers);
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> integers = new InorderTraversal().inorderTraversalIterative(treeNode);
        Assertions.assertEquals(List.of(4,2,5,1,6,3,7), integers);
    }

}