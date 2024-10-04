package com.sedykh.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 920. Meetings rooms (Meeting Schedule)
 * <p>
 * Given an array of meeting time interval objects consisting of start and end times
 * [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their
 * schedule without any conflicts.
 */
public class CanAttendMeetings {

    public boolean canAttendMeetings(List<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>(intervals);
        list.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start < list.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
