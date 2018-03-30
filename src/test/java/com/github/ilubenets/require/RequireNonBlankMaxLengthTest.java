package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class RequireNonBlankMaxLengthTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void length(
        final String value,
        final int maxLength,
        final String valueName
    ) {
        final Object requiredValue = Require.nonBlankMaxLength(value, maxLength, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void length_negative(
        final String value,
        final int maxLength,
        final String valueName
    ) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonBlankMaxLength(value, maxLength, valueName)
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of("a", 1, "1 char"),
            Arguments.of("valid case", 10, "10 chars")
        );
    }

    private static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of("", 1, "0 chars"),
            Arguments.of("           ", 10, "blank"),
            Arguments.of("12345678901", 10, "too long"),
            Arguments.of(null, 10, "null")
        );
    }
}
