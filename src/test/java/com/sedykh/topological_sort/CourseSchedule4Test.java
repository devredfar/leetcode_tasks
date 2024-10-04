package com.sedykh.topological_sort;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class CourseSchedule4Test {

    @Nested
    class MySolution {
        /**
         * Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]] Output: [false,true] Explanation: The
         * pair [1, 0] indicates that you have to take course 1 before you can take course 0. Course 0 is not a prerequisite
         * of course 1, but the opposite is true.
         */
        @Test
        void checkIfPrerequisite() {
            var prerequisites = TestUtils.parseToArray2dArray("[[1,0]]");
            var queries = TestUtils.parseToArray2dArray("[[0,1],[1,0]]");
            List<Boolean> actual = new CourseSchedule4.MySolution().checkIfPrerequisite(2, prerequisites, queries);
            Assertions.assertEquals(List.of(false, true), actual);
        }

        /**
         * Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
         * Output: [false,false]
         * Explanation: There are no prerequisites, and each course is independent.
         */
        @Test
        void checkIfPrerequisite2() {
            var queries = TestUtils.parseToArray2dArray("[[1,0],[0,1]]");
            List<Boolean> actual = new CourseSchedule4.MySolution().checkIfPrerequisite(2, new int[0][0], queries);
            Assertions.assertEquals(List.of(false, false), actual);
        }

        /**
         * Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
         * Output: [true,true]
         */
        @Test
        void checkIfPrerequisite3() {
            var prerequisites = TestUtils.parseToArray2dArray("[[1,2],[1,0],[2,0]]");
            var queries = TestUtils.parseToArray2dArray("[[1,0],[1,2]]");
            List<Boolean> actual = new CourseSchedule4.MySolution().checkIfPrerequisite(3, prerequisites, queries);
            Assertions.assertEquals(List.of(true, true), actual);
        }

        @Test
        void checkIfPrerequisite4() {
            var prerequisites = TestUtils.parseToArray2dArray("[[0,1],[1,2],[2,3],[3,4]]");
            var queries = TestUtils.parseToArray2dArray("[[0,4],[4,0],[1,3],[3,0]]");
            List<Boolean> actual = new CourseSchedule4.MySolution().checkIfPrerequisite(5, prerequisites, queries);
            Assertions.assertEquals(List.of(true, false, true, false), actual);
        }
    }

    @Nested
    class Optimal {
        /**
         * Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]] Output: [false,true] Explanation: The
         * pair [1, 0] indicates that you have to take course 1 before you can take course 0. Course 0 is not a prerequisite
         * of course 1, but the opposite is true.
         */
        @Test
        void checkIfPrerequisite() {
            var prerequisites = TestUtils.parseToArray2dArray("[[1,0]]");
            var queries = TestUtils.parseToArray2dArray("[[0,1],[1,0]]");
            List<Boolean> actual = new CourseSchedule4.Optimal().checkIfPrerequisite(2, prerequisites, queries);
            Assertions.assertEquals(List.of(false, true), actual);
        }

        /**
         * Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
         * Output: [false,false]
         * Explanation: There are no prerequisites, and each course is independent.
         */
        @Test
        void checkIfPrerequisite2() {
            var queries = TestUtils.parseToArray2dArray("[[1,0],[0,1]]");
            List<Boolean> actual = new CourseSchedule4.Optimal().checkIfPrerequisite(2, new int[0][0], queries);
            Assertions.assertEquals(List.of(false, false), actual);
        }

        /**
         * Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
         * Output: [true,true]
         */
        @Test
        void checkIfPrerequisite3() {
            var prerequisites = TestUtils.parseToArray2dArray("[[1,2],[1,0],[2,0]]");
            var queries = TestUtils.parseToArray2dArray("[[1,0],[1,2]]");
            List<Boolean> actual = new CourseSchedule4.Optimal().checkIfPrerequisite(3, prerequisites, queries);
            Assertions.assertEquals(List.of(true, true), actual);
        }

        @Test
        void checkIfPrerequisite4() {
            var prerequisites = TestUtils.parseToArray2dArray("[[0,1],[1,2],[2,3],[3,4]]");
            var queries = TestUtils.parseToArray2dArray("[[0,4],[4,0],[1,3],[3,0]]");
            List<Boolean> actual = new CourseSchedule4.Optimal().checkIfPrerequisite(5, prerequisites, queries);
            Assertions.assertEquals(List.of(true, false, true, false), actual);
        }
    }


}