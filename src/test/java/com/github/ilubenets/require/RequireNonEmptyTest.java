package com.github.ilubenets.require;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        final List<Integer> requiredList = Require.nonEmpty(list, "list");
        Assertions.assertIterableEquals(requiredList, list);

        final Set<String> set = new HashSet<>();
        set.add("SET");
        final Set<String> requiredSet = Require.nonEmpty(set, "set");
        Assertions.assertIterableEquals(requiredSet, set);
    }

    @Test
    void nonEmpty_map() {
        final Map<Integer, String> map = new HashMap<>();
        map.put(10, "Test");
        final Map<Integer, String> requiredList = Require.nonEmpty(map, "map");
        Assertions.assertEquals(requiredList, map);
    }

    @ParameterizedTest
    @MethodSource("stringInvalidCases")
    void nonEmpty_negative(final String value, final String valueName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(value, valueName));
    }

    @Test
    void nonEmpty_collection_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new HashSet(), "HashSet"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new ArrayList(), "ArrayList"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new LinkedList(), "LinkedList"));
    }

    @Test
    void nonEmpty_map_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Require.nonEmpty(new HashMap(), "HashMap"));
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Require.nonEmpty(new LinkedHashMap(), "LinkedHashMap")
        );
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
