package com.sedykh.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class MinMeetingRoomsTest {

    @Nested
    class MySolution {

        /**
         * Input: intervals = [(0,40),(5,10),(15,20)] Output: 2
         */
        @Test
        void minMeetingRooms() {
            int actual = new MinMeetingRooms.MySolution().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(0, 40),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(2, actual);
        }

        /**
         * Input: intervals = [(4,9)] Output: 1
         */
        @Test
        void minMeetingRooms2() {
            int actual = new MinMeetingRooms.MySolution().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(4, 9)
            ));
            Assertions.assertEquals(1, actual);
        }

        @Test
        void minMeetingRooms3() {
            int actual = new MinMeetingRooms.MySolution().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(0, 40),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(4, actual);
        }

        /**
         * intervals=[(1,5),(5,10),(10,15),(15,20)] output: 1
         */

        @Test
        void minMeetingRooms4() {
            int actual = new MinMeetingRooms.MySolution().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(1, 5),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(10, 15),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(1, actual);
        }
    }


    @Nested
    class Neetcode {

        /**
         * Input: intervals = [(0,40),(5,10),(15,20)] Output: 2
         */
        @Test
        void minMeetingRooms() {
            int actual = new MinMeetingRooms.Neetcode().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(0, 40),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(2, actual);
        }

        /**
         * Input: intervals = [(4,9)] Output: 1
         */
        @Test
        void minMeetingRooms2() {
            int actual = new MinMeetingRooms.Neetcode().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(4, 9)
            ));
            Assertions.assertEquals(1, actual);
        }

        @Test
        void minMeetingRooms3() {
            int actual = new MinMeetingRooms.Neetcode().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(0, 40),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(4, actual);
        }

        /**
         * intervals=[(1,5),(5,10),(10,15),(15,20)] output: 1
         */

        @Test
        void minMeetingRooms4() {
            int actual = new MinMeetingRooms.Neetcode().minMeetingRooms(List.of(
                    new MinMeetingRooms.Interval(1, 5),
                    new MinMeetingRooms.Interval(5, 10),
                    new MinMeetingRooms.Interval(10, 15),
                    new MinMeetingRooms.Interval(15, 20)
            ));
            Assertions.assertEquals(1, actual);
        }
    }
}