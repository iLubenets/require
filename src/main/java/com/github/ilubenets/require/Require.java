package com.github.ilubenets.require;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Static utility tool to check data validity requirements in the methods or constructors.
 * It has predefined error messages.
 *
 * If the requirements is not met, the {@code Require} method throws an unchecked exception {@code IllegalArgumentException},
 * to communicate that caller has made a mistake.
 *
 * Example:
 *
 * {@code
 *
 * // constructor
 * public RequestId(@Nullable final String value) {
 * this.value = Require.maxLength(value, 100, "requestId");
 * }
 *
 * }
 */
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

    /**
     * Check if {@param value} is not null.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static <T> T nonNull(@Nullable final T value, @Nonnull final String valueName) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NULL_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if {@param value} is not null and not blank, contains any character different from whitespace.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static String nonBlank(@Nullable final String value, @Nonnull final String valueName) {
        nonNull(value, valueName);

        final String valueWithoutWhitespaces = value.trim();
        if (valueWithoutWhitespaces.length() == 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_BLANK_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if {@param value} is not null and has length between {@param minLength} and {@param maxLength}.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param minLength - minimal expected value length
     * @param maxLength - maximal expected value length
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
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

    /**
     * Check if {@param value} is not null and has length between 0 and {@param maxLength}.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param maxLength - maximal expected value length
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static String maxLength(
        @Nullable final String value,
        final int maxLength,
        @Nonnull final String valueName
    ) {
        return length(value, 0, maxLength, valueName);
    }

    /**
     * Check if {@param value} is not blank and has length between 1 and {@param maxLength}.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param maxLength - maximal expected value length
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static String nonBlankMaxLength(
        @Nullable final String value,
        final int maxLength,
        @Nonnull final String valueName
    ) {
        return length(nonBlank(value, valueName), 1, maxLength, valueName);
    }

    /**
     * Check if {@param value} is not null and has length more then {@param minLength}.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param minLength - minimal expected value length
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
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

    /**
     * Check if {@param value} is not null and has match regexp pattern format.
     * If not throw an exception.
     *
     * @param value         - value to check
     * @param formatPattern - regexp format
     * @param valueName     - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
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

    /**
     * Check if numeric {@param value} is positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static int positive(final int value, @Nonnull final String valueName) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Integer positive(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.intValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} is positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static float positive(final float value, @Nonnull final String valueName) {
        if (value < 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Float positive(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.floatValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} is positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static long positive(final long value, @Nonnull final String valueName) {
        if (value < 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_POSITIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and positive.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Long positive(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        positive(value.longValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} is negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static int negative(final int value, @Nonnull final String valueName) {
        if (value > 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Integer negative(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.intValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} is negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static float negative(final float value, @Nonnull final String valueName) {
        if (value > 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Float negative(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.floatValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} is negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static long negative(final long value, @Nonnull final String valueName) {
        if (value > 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_NEGATIVE_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and negative.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Long negative(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        negative(value.longValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static int gtThanZero(final int value, @Nonnull final String valueName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Integer gtThanZero(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        gtThanZero(value.intValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static float gtThanZero(final float value, @Nonnull final String valueName) {
        if (value <= 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Float gtThanZero(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        gtThanZero(value.floatValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static long gtThanZero(final long value, @Nonnull final String valueName) {
        if (value <= 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_GREATER_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and grate than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Long gtThanZero(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        gtThanZero(value.longValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static int lsThanZero(final int value, @Nonnull final String valueName) {
        if (value >= 0) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Integer lsThanZero(@Nullable final Integer value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lsThanZero(value.intValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static float lsThanZero(final float value, @Nonnull final String valueName) {
        if (value >= 0.0F) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Float lsThanZero(@Nullable final Float value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lsThanZero(value.floatValue(), valueName);

        return value;
    }

    /**
     * Check if numeric {@param value} less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    public static long lsThanZero(final long value, @Nonnull final String valueName) {
        if (value >= 0L) {
            throw new IllegalArgumentException(String.format(VALUE_IS_NOT_LESS_THAN_ZERO_FORMAT, valueName));
        }

        return value;
    }

    /**
     * Check if numeric {@param value} is not null and less than 0.
     * If not throw an exception.
     *
     * @param value     - value to check
     * @param valueName - value parameter name which will be printed in the error message
     * @return {@param value} back to client
     * @throws IllegalArgumentException if statement false
     */
    @Nonnull
    public static Long lsThanZero(@Nullable final Long value, @Nonnull final String valueName) {
        nonNull(value, valueName);
        lsThanZero(value.longValue(), valueName);

        return value;
    }
}
