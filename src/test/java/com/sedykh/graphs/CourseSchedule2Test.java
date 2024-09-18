package com.sedykh.graphs;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CourseSchedule2Test {

    @Nested
    class MySolution {

        void findOrder1() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(1, new int[][]{});
            Assertions.assertArrayEquals(new int[]{0}, actual);
        }

        @Test
        void findOrderEmpty() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(2, new int[][]{{1, 0}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrder2() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(2, new int[][]{{1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1}, actual);
        }

        @Test
        void findOrder3() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(3, new int[][]{{2, 1}, {1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1, 2}, actual);
        }

        @Test
        void findOrder3NoAnswer() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrder4() {
            int[] actual = new CourseSchedule2.MySolution().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
            boolean firstSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            boolean secondSolution = Arrays.equals(new int[]{0, 1, 2, 3}, actual);
            boolean thirdSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            Assertions.assertTrue(firstSolution || secondSolution || thirdSolution);
        }
    }

    @Nested
    class LeetcodeSolution {

        @Test
        void findOrderLeetcodeSolution_1() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(1, new int[][]{});
            Assertions.assertArrayEquals(new int[]{0}, actual);
        }

        @Test
        void findOrderLeetcodeSolution_Empty() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(2, new int[][]{{1, 0}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrderLeetcodeSolution_2() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(2, new int[][]{{1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1}, actual);
        }

        @Test
        void findOrderLeetcodeSolution_3() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(3, new int[][]{{2, 1}, {1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1, 2}, actual);
        }

        @Test
        void findOrderLeetcodeSolution_3NoAnswer() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrderLeetcodeSolution_4() {
            int[] actual = new CourseSchedule2.LeetcodeSolution().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
            boolean firstSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            boolean secondSolution = Arrays.equals(new int[]{0, 1, 2, 3}, actual);
            boolean thirdSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            Assertions.assertTrue(firstSolution || secondSolution || thirdSolution);
        }
    }

    @Nested
    class MySolutionImproved {

        @Test
        void findOrderMySolutionImproved_1() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(1, new int[][]{});
            Assertions.assertArrayEquals(new int[]{0}, actual);
        }

        @Test
        void findOrderMySolutionImproved_Empty() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(2, new int[][]{{1, 0}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrderMySolutionImproved_2() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(2, new int[][]{{1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1}, actual);
        }

        @Test
        void findOrderMySolutionImproved_3() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(3, new int[][]{{2, 1}, {1, 0}});
            Assertions.assertArrayEquals(new int[]{0, 1, 2}, actual);
        }

        @Test
        void findOrderMySolutionImproved_3NoAnswer() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
            Assertions.assertArrayEquals(new int[]{}, actual);
        }

        @Test
        void findOrderMySolutionImproved_4() {
            int[] actual = new CourseSchedule2.MySolutionTopologicalSort().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
            boolean firstSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            boolean secondSolution = Arrays.equals(new int[]{0, 1, 2, 3}, actual);
            boolean thirdSolution = Arrays.equals(new int[]{0, 2, 1, 3}, actual);
            Assertions.assertTrue(firstSolution || secondSolution || thirdSolution);
        }
    }
}