package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class RequireLengthTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void length(
        final String value,
        final int minLength,
        final int maxLength,
        final String valueName
    ) {
        final Object requiredValue = Require.length(value, minLength, maxLength, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void length_negative(
        final String value,
        final int minLength,
        final int maxLength,
        final String valueName
    ) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.length(value, minLength, maxLength, valueName)
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of(" ", 1, 2, "1 whitespace"),
            Arguments.of("a", 1, 10, "1 char"),
            Arguments.of("valid case", 1, 10, "10 chars"),
            Arguments.of("", 0, 10, "0 chars")
        );
    }

    private static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of("", 1, 10, "too short"),
            Arguments.of("12345678901", 1, 10, "too long"),
            Arguments.of("           ", 1, 10, "too long whitespaces"),
            Arguments.of(null, 0, 10, "null")
        );
    }
}
