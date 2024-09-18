package com.sedykh.binary_search;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestTimeMap {

    private static Stream<Arguments> data() {
        TimeMap.Optimal.Data first = new TimeMap.Optimal.Data(1, "1");
        TimeMap.Optimal.Data second = new TimeMap.Optimal.Data(2, "2");
        TimeMap.Optimal.Data third = new TimeMap.Optimal.Data(3, "3");
        TimeMap.Optimal.Data four = new TimeMap.Optimal.Data(4, "4");
        TimeMap.Optimal.Data ten = new TimeMap.Optimal.Data(10, "10");
        return Stream.of(
            Arguments.of(List.of(first), 1, "1"),
            Arguments.of(List.of(first), 2, "1"),
            Arguments.of(List.of(first, second, third), 1, "1"),
            Arguments.of(List.of(first, second, third), 3, "3"),
            Arguments.of(List.of(first, second, third), -1, ""),
            Arguments.of(List.of(first, third), 2, "1"),
            Arguments.of(List.of(first, second, third, four, ten), 2, "2"),
            Arguments.of(List.of(first, second, third, four, ten), 9, "4")
        );
    }

    @Test
    public void test_MySolution_1() {
        TimeMap.MySolution timeMap = new TimeMap.MySolution();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        String result = timeMap.get("foo", 1);// return "bar"
        Assertions.assertEquals("bar", result);
        String result2 = timeMap.get("foo", 3);// return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        Assertions.assertEquals("bar", result2);
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        String result3 = timeMap.get("foo", 4);// return "bar2"
        Assertions.assertEquals("bar2", result3);
        String result4 = timeMap.get("foo", 5);// return "bar2"
        Assertions.assertEquals("bar2", result4);
    }

    @Test
    public void test_MySolution_2() {
        TimeMap.MySolution timeMap = new TimeMap.MySolution();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        String result = timeMap.get("love", 5);
        Assertions.assertEquals("", result);
        String result2 = timeMap.get("love", 10);
        Assertions.assertEquals("high", result2);
        String result3 = timeMap.get("love", 15);
        Assertions.assertEquals("high", result3);
        String result4 = timeMap.get("love", 20);
        Assertions.assertEquals("low", result4);
        String result5 = timeMap.get("love", 25);
        Assertions.assertEquals("low", result5);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test_optimal_binary_search(List<TimeMap.Optimal.Data> data, int timestamp, String expectedValue) {
        TimeMap.Optimal timeMap = new TimeMap.Optimal();
        String actualValue = timeMap.binarySearch(data, timestamp);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_Optimal_1() {
        TimeMap.Optimal timeMap = new TimeMap.Optimal();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        String result = timeMap.get("foo", 1);// return "bar"
        Assertions.assertEquals("bar", result);
        String result2 = timeMap.get("foo", 3);// return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        Assertions.assertEquals("bar", result2);
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        String result3 = timeMap.get("foo", 4);// return "bar2"
        Assertions.assertEquals("bar2", result3);
        String result4 = timeMap.get("foo", 5);// return "bar2"
        Assertions.assertEquals("bar2", result4);
    }

    @Test
    public void test_Optimal_2() {
        TimeMap.Optimal timeMap = new TimeMap.Optimal();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        String result = timeMap.get("love", 5);
        Assertions.assertEquals("", result);
        String result2 = timeMap.get("love", 10);
        Assertions.assertEquals("high", result2);
        String result3 = timeMap.get("love", 15);
        Assertions.assertEquals("high", result3);
        String result4 = timeMap.get("love", 20);
        Assertions.assertEquals("low", result4);
        String result5 = timeMap.get("love", 25);
        Assertions.assertEquals("low", result5);
    }
}
