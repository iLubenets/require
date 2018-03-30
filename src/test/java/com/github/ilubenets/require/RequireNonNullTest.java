package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class RequireNonNullTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void nonNull(final Object value, final String valueName) {
        final Object requiredValue = Require.nonNull(value, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void nonNull_negative() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonNull(null, "null")
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of("non blank", "non null"),
            Arguments.of("a", "1 char"),
            Arguments.of("      a     ", "1 char with whitespaces"),
            Arguments.of(" ", "whitespaces"),
            Arguments.of(0, "0 int"),
            Arguments.of(1L, "1 long"),
            Arguments.of(0.00000001F, "0.00000001 float")
        );
    }
}
