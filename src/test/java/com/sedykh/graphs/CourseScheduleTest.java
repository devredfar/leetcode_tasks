package com.sedykh.graphs;

import com.sedykh.topological_sort.CourseSchedule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseScheduleTest {

    @Test
    void canFinish_DFS_Naive_1() {
        boolean result = new CourseSchedule.DFSNaive().canFinish(2, new int[][]{{0, 1}});
        assertTrue(result);
    }

    @Test
    void canFinish_DFS_Naive_2() {
        boolean result = new CourseSchedule.DFSNaive().canFinish(2, new int[][]{{0, 1}, {1, 0}});
        assertFalse(result);
    }

    @Test
    void canFinish_DFS_Naive_3() {
        boolean result = new CourseSchedule.DFSNaive().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        assertTrue(result);
    }

    @Test
    void canFinish_DFS_Naive_4() {
        boolean result = new CourseSchedule.DFSNaive().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        assertFalse(result);
    }

    @Test
    void canFinish_TopologicalSort_1() {
        boolean result = new CourseSchedule.TopologicalSort().canFinish(2, new int[][]{{0, 1}});
        assertTrue(result);
    }

    @Test
    void canFinish_TopologicalSort_2() {
        boolean result = new CourseSchedule.TopologicalSort().canFinish(2, new int[][]{{0, 1}, {1, 0}});
        assertFalse(result);
    }

    @Test
    void canFinish_TopologicalSort_3() {
        boolean result = new CourseSchedule.TopologicalSort().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        assertTrue(result);
    }

    @Test
    void canFinish_TopologicalSort_4() {
        boolean result = new CourseSchedule.TopologicalSort().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        assertFalse(result);
    }
}