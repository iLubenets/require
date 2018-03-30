package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class RequireMinLengthTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void minLength(
        final String value,
        final int minLength,
        final String valueName
    ) {
        final Object requiredValue = Require.minLength(value, minLength, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void minLength_negative(
        final String value,
        final int minLength,
        final String valueName
    ) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.minLength(value, minLength, valueName)
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of("", 0, "0 chars"),
            Arguments.of(" ", 1, "1 whitespace"),
            Arguments.of("a", 1, "1 char"),
            Arguments.of("valid case", 10, "10 chars"),
            Arguments.of("the valid case", 10, "14 chars")
        );
    }

    private static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of("         ", 10, "too short whitespaces"),
            Arguments.of("123456789", 10, "too short"),
            Arguments.of(null, 10, "null")
        );
    }
}
