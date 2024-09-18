package com.sedykh.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 981. Time Based Key-Value Store
 * <p>
 * Design a time-based key-value data structure that can store multiple values for the
 * same key at different time stamps and retrieve the key's value at a certain timestamp. Implement the TimeMap class:
 * TimeMap() Initializes the object of the data structure. void set(String key, String value, int timestamp) Stores the
 * key key with the value value at the given time timestamp. String get(String key, int timestamp) Returns a value such
 * that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the
 * value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
public class TimeMap {

    public static class MySolution {

        java.util.HashMap<String, java.util.SortedMap<Integer, String>> map;

        public MySolution() {
            map = new java.util.HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.compute(key,
                (s, timeMap) -> {
                    if (timeMap == null) {
                        timeMap = new java.util.TreeMap<>();
                    }
                    timeMap.put(timestamp, value);
                    return timeMap;
                });
        }

        public String get(String key, int timestamp) {
            var timeMap = map.get(key);
            var partOfTheMap = timeMap.headMap(timestamp + 1);
            if (partOfTheMap.isEmpty()) {
                return "";
            }
            return partOfTheMap.get(partOfTheMap.lastKey());
        }
    }


    public static class Optimal {

        HashMap<String, List<TimeMap.Optimal.Data>> map;

        public Optimal() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, s -> new ArrayList<>()).add(new TimeMap.Optimal.Data(timestamp, value));
        }

        public String get(String key, int timestamp) {
            var timeMap = map.get(key);
            return binarySearch(timeMap, timestamp);
        }

        String binarySearch(List<TimeMap.Optimal.Data> timeMap, int timestamp) {
            String result = "";
            int l = 0;
            int r = timeMap.size() - 1;

            while (l <= r) {

                int mid = (l + r) / 2;

                TimeMap.Optimal.Data data = timeMap.get(mid);

                if (data.timestamp() == timestamp) {
                    return data.value();
                }
                if (data.timestamp() > timestamp) {
                    r = mid - 1;
                } else {
                    result = data.value();
                    l = mid + 1;
                }
            }

            return result;
        }

        record Data(int timestamp, String value) {

        }
    }
}
