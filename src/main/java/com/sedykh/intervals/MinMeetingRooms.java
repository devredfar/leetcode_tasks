package com.sedykh.intervals;

import java.util.Arrays;
import java.util.List;

/**
 * 919. Meetings rooms 2 (Meeting Schedule II)
 * <p>
 * Given an array of meeting time interval objects consisting of start and end times
 * [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all
 * meetings without any conflicts.
 */
public class MinMeetingRooms {

    public static class MySolution {
        public int minMeetingRooms(List<Interval> intervals) {
            int[] starts = new int[intervals.size()];
            int[] ends = new int[intervals.size()];
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);
                starts[i] = interval.start;
                ends[i] = interval.end;
            }
            Arrays.sort(starts);
            Arrays.sort(ends);
            int startPointer = 0;
            int endPointer = 0;
            int rooms = 0;
            int maxRooms = 0;
            while (startPointer < intervals.size()) {
                int endTime = ends[endPointer];
                int startTime = starts[startPointer];
                if (endTime < startTime) {
                    endPointer++;
                    rooms--;
                } else if (endTime == startTime) {
                    endPointer++;
                    startPointer++;
                } else {
                    startPointer++;
                    rooms++;
                    maxRooms = Math.max(maxRooms, rooms);
                }
            }
            return maxRooms;
        }
    }

    public static class Neetcode {
        public int minMeetingRooms(List<Interval> intervals) {
            if (intervals.isEmpty()) {
                return 0;
            }

            int len = intervals.size();
            int[] startTime = new int[len];
            int[] endTime = new int[len];

            for (int i = 0; i < len; i++) {
                startTime[i] = intervals.get(i).start;
                endTime[i] = intervals.get(i).end;
            }

            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int res = 0;
            int count = 0;
            int s = 0;
            int e = 0;

            while (s < len) {
                if (startTime[s] < endTime[e]) {
                    s++;
                    count++;
                } else {
                    e++;
                    count--;
                }
                res = Math.max(res, count);
            }

            return res;
        }
    }

    public static class Interval {

        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
