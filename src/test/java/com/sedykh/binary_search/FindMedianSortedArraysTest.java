package com.sedykh.binary_search;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindMedianSortedArraysTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void tesFindMedialSortedArrays_MySolution(int[] nums1, int[] nums2, double expecetedResult) {
        var result = new FindMedianSortedArrays.MySolution().findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(expecetedResult, result);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void tesFindMedialSortedArrays_Optimal(int[] nums1, int[] nums2, double expecetedResult) {
        var result = new FindMedianSortedArrays.Optimal().findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(expecetedResult, result);
    }
}