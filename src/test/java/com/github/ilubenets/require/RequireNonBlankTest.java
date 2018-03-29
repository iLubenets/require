package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

final class RequireNonBlankTest {

    @ParameterizedTest
    @MethodSource("nonBlankValues")
    void nonNull(final Object value) {
        final Object requiredValue = Require.nonNull(value, String.valueOf(value));
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @MethodSource("blankValues")
    void nonBlank_negative(final String value) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonBlank(value, "NonBlank")
        );
    }

    static List<Object> nonBlankValues() {
        final List<Object> testValues = new ArrayList<>();
        testValues.add(10);
        testValues.add(0);
        testValues.add(-1.0);
        testValues.add("a");
        testValues.add("NonBlank");

        return testValues;
    }

    static List<String> blankValues() {
        final List<String> testValues = new ArrayList<>();
        testValues.add("     ");
        testValues.add("");

        return testValues;
    }
}
