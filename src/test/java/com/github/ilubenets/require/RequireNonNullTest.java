package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

final class RequireNonNullTest {

    @ParameterizedTest
    @MethodSource("nonNullValues")
    void nonNull(final Object value) {
        final Object requiredValue = Require.nonNull(value, String.valueOf(value));
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void nonNull_negative() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonNull(null, "NonNull")
        );
    }

    static List<Object> nonNullValues() {
        final List<Object> testValues = new ArrayList<>();
        testValues.add("");
        testValues.add(" ");
        testValues.add(10);
        testValues.add(0);
        testValues.add(-1.0);
        testValues.add("NonNull");

        return testValues;
    }
}
