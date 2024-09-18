package com.sedykh.binary_search;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static com.sedykh.binary_search.BinarySearch.search;

public class TestSearch {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 1, 0),
                Arguments.of(new int[]{1, 2, 3}, 2, 1),
                Arguments.of(new int[]{1, 2, 3}, 3, 2),
                Arguments.of(new int[]{1, 2, 3}, 4, -1),
                Arguments.of(new int[]{3, 1, 2}, 1, 1),
                Arguments.of(new int[]{3, 1, 2}, 2, 2),
                Arguments.of(new int[]{3, 1, 2}, 3, 0),
                Arguments.of(new int[]{3, 1, 2}, 4, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(int[] nums, int target, int expecetedResult) {
        var result = search(nums, target);
        Assertions.assertEquals(expecetedResult, result);
    }
}
