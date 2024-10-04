package com.sedykh.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CanAttendMeetingsTest {

    /**
     * Input: intervals = [(0,30),(5,10),(15,20)]
     * Output: false
     */
    @Test
    void canAttendMeetings() {
        boolean actual = new CanAttendMeetings().canAttendMeetings(List.of(
                new CanAttendMeetings.Interval(0, 30),
                new CanAttendMeetings.Interval(5, 10),
                new CanAttendMeetings.Interval(15, 20)
        ));
        Assertions.assertFalse(actual);
    }

    /**
     * Input: intervals = [(5,8),(9,15)]
     * Output: true
     */
    @Test
    void canAttendMeetings2() {
        boolean actual = new CanAttendMeetings().canAttendMeetings(List.of(
                new CanAttendMeetings.Interval(5, 8),
                new CanAttendMeetings.Interval(9, 15)
        ));
        Assertions.assertTrue(actual);
    }
}