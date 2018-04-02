package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class RequireLsThanZeroTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void lsThanZero(final int value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {-1L, -100L})
    void lsThanZero(final long value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {-0.1F, -1.1F, -100.01F})
    void lsThanZero(final float value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1D, -1.1D, -100.01D})
    void lsThanZero(final double value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1D, -1.1D, -100.01D})
    void lsThanZero(final Double value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void lsThanZero(final Integer value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {-1L, -100L})
    void lsThanZero(final Long value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {-0.1F, -1.1F, -100.01F})
    void lsThanZero(final Float value) {
        final Object requiredValue = Require.lsThanZero(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void lsThanZero_int_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(0, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(1, "1"));
    }

    @Test
    void lsThanZero_boxed_int_negative() {
        final Integer value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Integer.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Integer.valueOf(1), "1"));
    }

    @Test
    void lsThanZero_float_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(0F, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(1.1F, "1.1"));
    }

    @Test
    void lsThanZero_boxed_float_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Float.valueOf(0F), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Float.valueOf(1.1F), "1.1"));
    }

    @Test
    void lsThanZero_double_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(0D, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(1.1D, "1.1"));
    }

    @Test
    void lsThanZero_boxed_double_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Double.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Double.valueOf(1.1D), "1.1"));
    }

    @Test
    void lsThanZero_long_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(0L, "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(10L, "10"));
    }

    @Test
    void lsThanZero_boxed_long_negative() {
        final Long value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Long.valueOf(0), "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.lsThanZero(Long.valueOf(10L), "10"));
    }
}
