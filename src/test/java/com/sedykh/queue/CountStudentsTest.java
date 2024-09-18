package com.sedykh.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountStudentsTest {

    @Test
    void countStudents() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1, 1, 1, 0, 0, 1},
                new int[]{1, 0, 0, 0, 1, 1});
        assertEquals(3, actualResult);
    }

    @Test
    void countStudents2() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1},
                new int[]{1});
        assertEquals(0, actualResult);
    }

    @Test
    void countStudents3() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1, 0},
                new int[]{1, 0});
        assertEquals(0, actualResult);
    }

    @Test
    void countStudents4() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0});
        assertEquals(0, actualResult);
    }

    @Test
    void countStudents5() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1, 0, 1},
                new int[]{1, 0, 0});
        assertEquals(2, actualResult);
    }

    @Test
    void countStudents6() {
        int actualResult = new CountStudents().countStudents(
                new int[]{1, 1, 1},
                new int[]{1, 1, 0});
        assertEquals(3, actualResult);
    }

    @Test
    void countStudents7() {
        int actualResult = new CountStudents().countStudents(
                new int[]{0, 0, 1},
                new int[]{1, 1, 1});
        assertEquals(2, actualResult);
    }
}