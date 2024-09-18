package com.sedykh;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUtilsTest {

    @Test
    public void testContainsListInAnyOrder_ActualNotContainsAll() {
        assertThrows(AssertionError.class, () -> TestUtils.containsAllInAnyOrder(
            List.of(List.of(1)), List.of(List.of(1), List.of(2))));
    }

    @Test
    public void testContainsListInAnyOrder_same() {
        TestUtils.containsAllInAnyOrder(List.of(List.of(1)), List.of(List.of(1)));
    }

    @Test
    public void testContainsListInAnyOrder_ActualHasMoreData() {
        TestUtils.containsAllInAnyOrder(List.of(List.of(1), List.of(2)), List.of(List.of(1)));
    }

    @Test
    public void testEqualsInAnyOrder_Equals() {
        TestUtils.equalsInAnyOrder(List.of(List.of(1), List.of(2)), List.of(List.of(2), List.of(1)));
    }

    @Test
    public void testEqualsInAnyOrder_ActualNotContainsAll() {
        assertThrows(AssertionError.class, () -> TestUtils.equalsInAnyOrder(
            List.of(List.of(1)), List.of(List.of(1), List.of(2))));
    }

    @Test
    public void testEqualsInAnyOrder_ExpectedNotContainsAll() {
        assertThrows(AssertionError.class, () -> TestUtils.equalsInAnyOrder(
            List.of(List.of(1), List.of(2)), List.of(List.of(1))));
    }

    @Test
    public void testParse() {
        List<List<Integer>> actual = TestUtils.parseToList("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
        List<List<Integer>> expected = List.of(
            List.of(),
            List.of(1),
            List.of(2),
            List.of(1, 2),
            List.of(3),
            List.of(1, 3),
            List.of(2, 3),
            List.of(1, 2, 3)
        );
        TestUtils.equalsInAnyOrder(actual, expected);
    }

}