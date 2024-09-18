package com.sedykh.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCalendarTest {

    @Test
    void book() {
        MyCalendar myCalendar = new MyCalendar();
        assertTrue(myCalendar.book(0, 1));
        assertTrue(myCalendar.book(1, 2));
        assertFalse(myCalendar.book(0, 2));
        assertTrue(myCalendar.book(100, 200));
        assertFalse(myCalendar.book(1, 200));
    }
}