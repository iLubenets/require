package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class RequireGtThanZeroTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    void gtThanZero(final int value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 100L})
    void gtThanZero(final long value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {0.1F, 1.1F, 100.01F})
    void gtThanZero(final float value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1D, 1.1D, 100.01D})
    void gtThanZero(final double value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1D, 1.1D, 100.01D})
    void gtThanZero(final Double value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    void gtThanZero(final Integer value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 100L})
    void gtThanZero(final Long value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {0.1F, 1.1F, 100.01F})
    void gtThanZero(final Float value) {
        final Object requiredValue = Require.gtThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void gtThanZero_int_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(0, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(-1, "-1"));
    }

    @Test
    void gtThanZero_boxed_int_negative() {
        final Integer value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Integer.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Integer.valueOf(-1), "-1"));
    }

    @Test
    void gtThanZero_float_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(0F, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(-1.1F, "-1.1"));
    }

    @Test
    void gtThanZero_boxed_float_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Float.valueOf(0F), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Float.valueOf(-1.1F), "-1.1"));
    }

    @Test
    void gtThanZero_double_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(0D, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(-1.1D, "-1.1"));
    }

    @Test
    void gtThanZero_boxed_double_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Double.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Double.valueOf(-1.1D), "-1.1"));
    }

    @Test
    void gtThanZero_long_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(0L, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(-10L, "-10"));
    }

    @Test
    void gtThanZero_boxed_long_negative() {
        final Long value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Long.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.gtThanZero(Long.valueOf(-10L), "-10"));
    }
}
