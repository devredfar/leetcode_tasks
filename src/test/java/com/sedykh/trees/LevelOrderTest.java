package com.sedykh.trees;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelOrderTest {

    @Test
    void levelOrder() {
        TreeNode root = TreeNode.of(new Integer[]{3,9,20,null,null,15,7});
        var actualResult = LevelOrder.levelOrder(root);
        Assertions.assertEquals(List.of(List.of(3), List.of(9,20), List.of(15,7)), actualResult);
    }
}