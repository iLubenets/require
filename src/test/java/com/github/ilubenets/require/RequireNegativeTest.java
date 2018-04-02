package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class RequireNegativeTest {

    @ParameterizedTest
    @ValueSource(ints = {-0, -1, -100})
    void negative(final int value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {-0L, -1L, -100L})
    void negative(final long value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {-0F, -0.1F, -1.1F, -100.01F})
    void negative(final float value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0D, -0.1D, -1.1D, -100.01D})
    void negative(final double value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0D, -0.1D, -1.1D, -100.01D})
    void negative(final Double value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-0, -1, -100})
    void negative(final Integer value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(longs = {-0L, -1L, -100L})
    void negative(final Long value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @ParameterizedTest
    @ValueSource(floats = {-0F, -0.1F, -1.1F, -100.01F})
    void negative(final Float value) {
        final Object requiredValue = Require.negative(value, value + " value");
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void negative_int_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(1, "1"));
    }

    @Test
    void negative_boxed_int_negative() {
        final Integer value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(Integer.valueOf(1), "1"));
    }

    @Test
    void negative_float_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(1.1F, "1.1"));
    }

    @Test
    void negative_boxed_float_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(Float.valueOf(1.1F), "1.1"));
    }

    @Test
    void negative_double_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(1.1D, "1.1"));
    }

    @Test
    void negative_boxed_double_negative() {
        final Float value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(Double.valueOf(1.1D), "1.1"));
    }

    @Test
    void negative_long_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(10L, "10"));
    }

    @Test
    void negative_boxed_long_negative() {
        final Long value = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(value, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.negative(Long.valueOf(10L), "10"));
    }
}
