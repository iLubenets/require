package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

final class RequireFormatTest {

    @ParameterizedTest
    @MethodSource("validCases")
    void length(
        final String value,
        final Pattern pattern,
        final String valueName
    ) {
        final Object requiredValue = Require.format(value, pattern, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void length_negative(
        final String value,
        final Pattern pattern,
        final String valueName
    ) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.format(value, pattern, valueName)
        );
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of("1234560", Pattern.compile("\\d+"), "only digits"),
            Arguments.of(
                "2001-12-01",
                Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$"),
                "Dates in yyyy-mm-dd format from 1900-01-01 to 2099-12-31"
            )
        );
    }

    private static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of("12A4560", Pattern.compile("\\d+"), "only digits, invalid with char"),
            Arguments.of("12 4560", Pattern.compile("\\d+"), "only digits, invalid with whitespace"),
            Arguments.of(
                "201-12-01",
                Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$"),
                "Dates in yyyy-mm-dd format from 1900-01-01 to 2099-12-31. Invalid 201-12-01"
            ),
            Arguments.of(
                "2001-12-01 ",
                Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$"),
                "Dates in yyyy-mm-dd format from 1900-01-01 to 2099-12-31. Invalid with whitespace."
            )
        );
    }
}
