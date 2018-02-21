package com.github.ilubenets.require;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public final class RequireTest {

    @Test
    public void nonNull() {
        final List<Object> testValues = new ArrayList<>();
        testValues.add("");
        testValues.add(" ");
        testValues.add(10);
        testValues.add(0);
        testValues.add(-0);
        testValues.add(-1.0);
        testValues.add("NonNull");

        testValues.forEach(
            value -> {
                final Object requiredValue = Require.nonNull(value, String.valueOf(value));
                Assert.assertEquals(requiredValue, value);
            }
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonNull_negative() {
        Require.nonNull(null, "null value");
    }
}
