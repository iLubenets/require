package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class RequirePositiveTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void positive(final int value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {0L, 1L, 100L})
    void positive(final long value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {0F, 0.1F, 1.1F, 100.01F})
    void positive(final float value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0D, 0.1D, 1.1D, 100.01D})
    void positive(final double value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0D, 0.1D, 1.1D, 100.01D})
    void positive(final Double value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void positive(final Integer value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {0L, 1L, 100L})
    void positive(final Long value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {0F, 0.1F, 1.1F, 100.01F})
    void positive(final Float value) {
        final Object requiredValue = Require.positive(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void positive_int_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(-1, "-1"));
    }

    @Test
    void positive_boxed_int_negative() {
        final Integer value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(Integer.valueOf(-1), "-1"));
    }

    @Test
    void positive_float_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(-1.1F, "-1.1"));
    }

    @Test
    void positive_boxed_float_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(Float.valueOf(-1.1F), "-1.1"));
    }

    @Test
    void positive_double_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(-1.1D, "-1.1"));
    }

    @Test
    void positive_boxed_double_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(Double.valueOf(-1.1D), "-1.1"));
    }

    @Test
    void positive_long_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(-10L, "-10"));
    }

    @Test
    void positive_boxed_long_negative() {
        final Long value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.positive(Long.valueOf(-10L), "-10"));
    }
}
