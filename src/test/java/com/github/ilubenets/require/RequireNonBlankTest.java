package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class RequireNonBlankTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void nonBlank(final String value, final String valueName) {
        final Object requiredValue = Require.nonBlank(value, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void nonBlank_negative(final String value, final String valueName) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonBlank(value, valueName)
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of("non blank", "non blank"),
            Arguments.of("a", "1 char"),
            Arguments.of("      a     ", "1 char with whitespaces")
        );
    }

    private static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of("     ", "only whitespaces"),
            Arguments.of("", "empty")
        );
    }
}
