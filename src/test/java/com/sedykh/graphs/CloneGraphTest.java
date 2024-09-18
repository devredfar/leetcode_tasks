package com.sedykh.graphs;

import com.sedykh.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class CloneGraphTest {

    @Test
    void cloneGraph() {
        Node node = Node.from(List.of(List.of(2, 4), List.of(1, 3), List.of(2, 4), List.of(1, 3)));
        Node actual = new CloneGraph().cloneGraph(node);
        TestUtils.assertEquals(node, actual);
    }
}