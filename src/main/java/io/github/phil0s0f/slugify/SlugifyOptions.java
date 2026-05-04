package io.github.phil0s0f.slugify;

import java.util.Objects;

/**
 * Options for configuring slug generation.
 */
public final class SlugifyOptions {
    private final String separator;
    private final boolean lowercase;
    private final boolean trimSeparators;

    private SlugifyOptions(Builder builder) {
        this.separator = builder.separator;
        this.lowercase = builder.lowercase;
        this.trimSeparators = builder.trimSeparators;
    }

    /**
     * Creates default options.
     *
     * @return default slugify options
     */
    public static SlugifyOptions defaults() {
        return builder().build();
    }

    /**
     * Creates a new options builder.
     *
     * @return options builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns the separator used between words.
     *
     * @return separator
     */
    public String separator() {
        return separator;
    }

    /**
     * Returns whether output should be lowercased.
     *
     * @return true if output should be lowercased
     */
    public boolean lowercase() {
        return lowercase;
    }

    /**
     * Returns whether leading and trailing separators should be removed.
     *
     * @return true if leading and trailing separators should be removed
     */
    public boolean trimSeparators() {
        return trimSeparators;
    }

    public static final class Builder {
        private String separator = "-";
        private boolean lowercase = true;
        private boolean trimSeparators = true;

        private Builder() {
        }

        /**
         * Sets the word separator.
         *
         * @param separator separator to use
         * @return this builder
         */
        public Builder separator(String separator) {
            Objects.requireNonNull(separator, "separator must not be null");
            if (separator.isEmpty()) {
                throw new IllegalArgumentException("separator must not be empty");
            }
            this.separator = separator;
            return this;
        }

        /**
         * Sets whether output should be lowercased.
         *
         * @param lowercase true to lowercase output
         * @return this builder
         */
        public Builder lowercase(boolean lowercase) {
            this.lowercase = lowercase;
            return this;
        }

        /**
         * Sets whether leading and trailing separators should be removed.
         *
         * @param trimSeparators true to trim leading and trailing separators
         * @return this builder
         */
        public Builder trimSeparators(boolean trimSeparators) {
            this.trimSeparators = trimSeparators;
            return this;
        }

        /**
         * Builds immutable options.
         *
         * @return slugify options
         */
        public SlugifyOptions build() {
            return new SlugifyOptions(this);
        }
    }
}
