package com.sedykh.string;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsNumberTest {

    private static Stream<Arguments> validNumbers() {
        return Stream.of(
            Arguments.of("2"),
            Arguments.of("0089"),
            Arguments.of("2"),
            Arguments.of("-0.1"),
            Arguments.of("-0.1"),
            Arguments.of("+3.14"),
            Arguments.of("4."),
            Arguments.of("-.9"),
            Arguments.of("-2e10"),
            Arguments.of("46.e3"),
            Arguments.of("-90E3"),
            Arguments.of("3e+7"),
            Arguments.of("+6e-1"),
            Arguments.of("53.5e93"),
            Arguments.of("-123.456e789")
        );
    }

    private static Stream<Arguments> invalidNumbers() {
        return Stream.of(
            Arguments.of("abc"),
            Arguments.of("1a"),
            Arguments.of("1e"),
            Arguments.of("e3"),
            Arguments.of("1ee3"),
            Arguments.of(".e3"),
            Arguments.of("99e2.5"),
            Arguments.of("--6"),
            Arguments.of("+-3"),
            Arguments.of("+6e-"),
            Arguments.of("95e54e53"),
            Arguments.of("-100.1.e3")
        );
    }

    @ParameterizedTest
    @MethodSource("validNumbers")
    void isNumber_MySolution_Valid(String s) {
        boolean actual = new IsNumber.MySolution().isNumber(s);
        Assertions.assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("validNumbers")
    void isNumber_Simplified_Valid(String s) {
        boolean actual = new IsNumber.Simplified().isNumber(s);
        Assertions.assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("invalidNumbers")
    void isNumber_MySolution_Invalid(String s) {
        boolean actual = new IsNumber.MySolution().isNumber(s);
        Assertions.assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("invalidNumbers")
    void isNumber_Simplified_Invalid(String s) {
        boolean actual = new IsNumber.Simplified().isNumber(s);
        Assertions.assertFalse(actual);
    }
}