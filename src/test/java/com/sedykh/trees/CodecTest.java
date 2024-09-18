package com.sedykh.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CodecTest {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        TreeNode tree = new Codec().deserialize(new Codec().serialize(root));
        Assertions.assertEquals(root, tree);
    }

    @Test
    void test2() {
        TreeNode root = TreeNode.of(new Integer[]{1,2,3});
        TreeNode tree = new Codec().deserialize(new Codec().serialize(root));
        Assertions.assertEquals(root, tree);
    }

    @Test
    void test3() {
        TreeNode root = TreeNode.of(new Integer[]{1,2,3,4,5,6,7});
        TreeNode tree = new Codec().deserialize(new Codec().serialize(root));
        Assertions.assertEquals(root, tree);
    }


    @Test
    void test4() {
        TreeNode root = TreeNode.of(new Integer[]{1,2,3,null,null,6,7});
        String serialize = new Codec().serialize(root);
        TreeNode tree = new Codec().deserialize(serialize);
        Assertions.assertEquals(root, tree);
    }

    @Test
    void test5() {
        String serialize = new Codec().serialize(null);
        TreeNode tree = new Codec().deserialize(serialize);
        Assertions.assertNull(tree);
    }
}