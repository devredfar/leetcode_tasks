package com.sedykh.graphs;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

class PacificAtlanticTest {

    @Test
    void pacificAtlantic() {
        var params = new int[][]{
                new int[]{1, 2, 2, 3, 5},
                new int[]{3, 2, 3, 4, 4},
                new int[]{2, 4, 5, 3, 1},
                new int[]{6, 7, 1, 4, 5},
                new int[]{5, 1, 1, 2, 4}
        };

        List<List<Integer>> actualResult = new PacificAtlantic().pacificAtlantic(params);

        assertThat(actualResult, hasSize(7));
        assertThat("List equality without order", actualResult, containsInAnyOrder(List.of(0, 4),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 2),
                List.of(3, 0),
                List.of(3, 1),
                List.of(4, 0)));
    }
}