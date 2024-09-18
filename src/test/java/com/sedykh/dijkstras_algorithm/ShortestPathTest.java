package com.sedykh.dijkstras_algorithm;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathTest {
    @Test
    void shortestPath_MySolution() {
        Map<Integer, Integer> actualResult = new ShortestPath.MySolution().shortestPath(5,
                List.of(
                        List.of(0, 1, 10),
                        List.of(0, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 4),
                        List.of(2, 3, 8),
                        List.of(2, 4, 2),
                        List.of(3, 4, 5)),
                0);
        assertEquals(
            Map.of(0, 0, 1, 7, 2, 3, 3, 9, 4, 5),
            actualResult);
    }

    @Test
    void shortestPath_Simplified() {
        Map<Integer, Integer> actualResult = new ShortestPath.Simplified().shortestPath(5,
            List.of(
                List.of(0, 1, 10),
                List.of(0, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 4),
                List.of(2, 3, 8),
                List.of(2, 4, 2),
                List.of(3, 4, 5)),
            0);
        assertEquals(
            Map.of(0, 0, 1, 7, 2, 3, 3, 9, 4, 5),
            actualResult);
    }
}