package com.sedykh.linked_lists;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CopyRandomListTest {
    @Test
    void copyRandomList(){
        Node node = Node.of(List.of(1, 2), List.of("1", "1"));
        Node actualList = CopyRandomList.copyRandomList(node);
        Assertions.assertEquals(node, actualList);
    }
}