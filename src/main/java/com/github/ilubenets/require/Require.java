package com.github.ilubenets.require;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Require {

    private final static String VALUE_IS_NULL_FORMAT = "The value of [%s] must not be null.";
    private final static String VALUE_IS_BLANK_FORMAT = "The value of [%s] must not be blank.";
    private final static String VALUE_HAS_WRONG_FORMAT_FORMAT = "The value of [%s] has invalid format.";
    private final static String VALUE_HAS_WRONG_LENGTH_FORMAT = "The length of [%s] must be between %d-%d.";
    private final static String VALUE_HAS_WRONG_MIN_LENGTH_FORMAT = "The length of [%s] must at least %d.";
    private final static String VALUE_IS_NOT_POSITIVE_FORMAT = "The value of [%s] must be positive or 0.";
    private final static String VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT = "The value of [%s] must be greater than 0.";
    private final static String VALUE_IS_NOT_NEGATIVE_FORMAT = "The value of [%s] must be negative or 0.";
    private final static String VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT = "The value of [%s] must be less than 0.";

    private Require() {
        // Utility class
    }

    @Nonnull
    public static <T> T nonNull(@Nullable final T value, @Nonnull final String valueName) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NULL_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static String nonBlank(@Nullable final String value, @Nonnull final String valueName) {
        nonNull(value, valueName);

        final String valueWithoutWhitespaces = value.trim();
        if (valueWithoutWhitespaces.length() == 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_BLANK_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static String length(
        @Nullable final String value,
        final int minLength,
        final int maxLength,
        @Nonnull final String valueName
    ) {
        nonNull(value, valueName);

        final int valueLength = value.length();
        if (valueLength < minLength || valueLength > maxLength) {
            throw new IllegalArgumentException(
                String.format(VALUE_HAS_WRONG_LENGTH_FORMAT, valueName, minLength, maxLength)
            );
        }

        return value;
    }

    @Nonnull
    public static String maxLength(
        @Nullable final String value,
        final int maxLength,
        @Nonnull final String valueName
    ) {
        nonNull(value, valueName);
        length(value, 0, maxLength, valueName);

        return value;
    }

    @Nonnull
    public static String minLength(
        @Nullable final String value,
        final int minLength,
        @Nonnull final String valueName
    ) {
        nonNull(value, valueName);

        final int valueLength = value.length();
        if (valueLength < minLength) {
            throw new IllegalArgumentException(String.format(VALUE_HAS_WRONG_MIN_LENGTH_FORMAT, valueName, minLength));
        }

        return value;
    }

    public static String format(
        @Nullable final String value,
        @Nonnull final Pattern formatPattern,
        @Nonnull final String valueName
    ) {
        nonNull(value, valueName);

        if (!formatPattern.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format(VALUE_HAS_WRONG_FORMAT_FORMAT, valueName));
        }

        return value;
    }

    public static int positive(final int value, @Nonnull final String valueName) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Integer positive(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.intValue(), valueName);

        return value;
    }

    public static float positive(final float value, @Nonnull final String valueName) {
        if (value < 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Float positive(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.floatValue(), valueName);

        return value;
    }

    public static long positive(final long value, @Nonnull final String valueName) {
        if (value < 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Long positive(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.longValue(), valueName);

        return value;
    }

    public static int greaterThanZero(final int value, @Nonnull final String valueName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Integer greaterThanZero(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        greaterThanZero(value.intValue(), valueName);

        return value;
    }

    public static float greaterThanZero(final float value, @Nonnull final String valueName) {
        if (value <= 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Float greaterThanZero(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        greaterThanZero(value.floatValue(), valueName);

        return value;
    }

    public static long greaterThanZero(final long value, @Nonnull final String valueName) {
        if (value <= 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Long greaterThanZero(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        greaterThanZero(value.longValue(), valueName);

        return value;
    }

    public static int negative(final int value, @Nonnull final String valueName) {
        if (value > 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Integer negative(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.intValue(), valueName);

        return value;
    }

    public static float negative(final float value, @Nonnull final String valueName) {
        if (value > 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Float negative(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.floatValue(), valueName);

        return value;
    }

    public static long negative(final long value, @Nonnull final String valueName) {
        if (value > 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Long negative(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.longValue(), valueName);

        return value;
    }

    public static int lessThanZero(final int value, @Nonnull final String valueName) {
        if (value >= 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Integer lessThanZero(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lessThanZero(value.intValue(), valueName);

        return value;
    }

    public static float lessThanZero(final float value, @Nonnull final String valueName) {
        if (value >= 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Float lessThanZero(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lessThanZero(value.floatValue(), valueName);

        return value;
    }

    public static long lessThanZero(final long value, @Nonnull final String valueName) {
        if (value >= 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    @Nonnull
    public static Long lessThanZero(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lessThanZero(value.longValue(), valueName);

        return value;
    }
}
