package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

final class RequireNonEmptyTest {

    @ParameterizedTest
    @MethodSource("stringValidCases")
    void nonEmpty(final String value, final String valueName) {
        final Object requiredValue = Require.nonEmpty(value, valueName);
        Assertions.assertEquals(requiredValue, value);
    }

    @Test
    void nonEmpty_collection() {
        final Collection<Integer> collection = Collections.singletonList(1);
        final Collection<Integer> requiredCollection = Require.nonEmpty(collection, "collection");
        Assertions.assertIterableEquals(requiredCollection, collection);

        final List<String> list = Collections.singletonList("test");
        final List<String> requiredList = Require.nonEmpty(list, "list");
        Assertions.assertIterableEquals(requiredList, list);

        final Set<String> set = new HashSet<>();
        set.add("TEST");
        final Set<String> requiredSet = Require.nonEmpty(set, "set");
        Assertions.assertIterableEquals(requiredSet, set);
    }

    @Test
    void nonEmpty_map() {
        final Map<Integer, String> map = Collections.singletonMap(10, "Test");
        final Map<Integer, String> requiredList = Require.nonEmpty(map, "map");
        Assertions.assertEquals(requiredList, map);
    }

    @Test
    void nonEmpty_enumeration() {
        final Enumeration enumeration = Collections.enumeration(Collections.singletonList("test"));
        final Enumeration requiredEnumeration = Require.nonEmpty(enumeration, "enumeration");
        Assertions.assertEquals(requiredEnumeration, enumeration);
    }

    @Test
    void nonEmpty_object_array() {
        final Integer[] array = new Integer[1];
        final Integer[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_char_array() {
        final char[] array = new char[1];
        final char[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_byte_array() {
        final byte[] array = new byte[1];
        final byte[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_int_array() {
        final int[] array = new int[1];
        final int[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_long_array() {
        final long[] array = new long[1];
        final long[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_float_array() {
        final float[] array = new float[1];
        final float[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @Test
    void nonEmpty_double_array() {
        final double[] array = new double[1];
        final double[] requiredArray = Require.nonEmpty(array, "array");
        Assertions.assertEquals(requiredArray, array);
    }

    @ParameterizedTest
    @MethodSource("stringInvalidCases")
    void nonEmpty_negative(final String value, final String valueName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(value, valueName));
    }

    @Test
    void nonEmpty_collection_negative() {
        final Collection<Integer> collection = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(collection, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new ArrayList(), "empty"));
    }

    @Test
    void nonEmpty_map_negative() {
        final Map<Integer, String> map = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(map, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new HashMap(), "empty"));
    }

    @Test
    void nonEmpty_enumeration_negative() {
        final Enumeration enumeration = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(enumeration, "null"));
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonEmpty(Collections.emptyEnumeration(), "empty")
        );
    }

    @Test
    void nonEmpty_object_array_negative() {
        final Integer[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonEmpty(new Integer[0], "LinkedHashMap")
        );
    }

    @Test
    void nonEmpty_char_array_negative() {
        final char[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new char[0], "empty"));
    }

    @Test
    void nonEmpty_byte_array_negative() {
        final byte[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new byte[0], "empty"));
    }

    @Test
    void nonEmpty_int_array_negative() {
        final int[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new int[0], "empty"));
    }

    @Test
    void nonEmpty_long_array_negative() {
        final long[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new long[0], "empty"));
    }

    @Test
    void nonEmpty_float_array_negative() {
        final float[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new float[0], "empty"));
    }

    @Test
    void nonEmpty_double_array_negative() {
        final double[] array = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(array, "null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new double[0], "empty"));
    }

    private static Stream<Arguments> stringValidCases() {
        return Stream.of(
            Arguments.of("non blank", "non empty"),
            Arguments.of("a", "1 char"),
            Arguments.of("           ", "only whitespaces")
        );
    }

    private static Stream<Arguments> stringInvalidCases() {
        return Stream.of(
            Arguments.of(null, "null"),
            Arguments.of("", "empty")
        );
    }
}
