package io.github.phil0s0f.slugify;

import java.text.Normalizer;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Utility class for converting text into URL-friendly slugs.
 */
public final class Slugifier {
    private static final Pattern DIACRITICS = Pattern.compile("\\p{M}+");
    private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^\\p{Alnum}]+");

    private Slugifier() {
    }

    /**
     * Converts text into a URL-friendly slug using default options.
     *
     * @param input text to convert
     * @return generated slug
     */
    public static String slugify(String input) {
        return slugify(input, SlugifyOptions.defaults());
    }

    /**
     * Converts text into a URL-friendly slug using custom options.
     *
     * @param input text to convert
     * @param options slugify options
     * @return generated slug
     */
    public static String slugify(String input, SlugifyOptions options) {
        Objects.requireNonNull(input, "input must not be null");
        Objects.requireNonNull(options, "options must not be null");

        String result = Normalizer.normalize(input, Normalizer.Form.NFD);
        result = DIACRITICS.matcher(result).replaceAll("");

        if (options.lowercase()) {
            result = result.toLowerCase();
        }

        result = NON_ALPHANUMERIC.matcher(result).replaceAll(options.separator());

        if (options.trimSeparators()) {
            result = trimSeparator(result, options.separator());
        }

        return result;
    }

    private static String trimSeparator(String value, String separator) {
        String result = value;

        while (result.startsWith(separator)) {
            result = result.substring(separator.length());
        }

        while (result.endsWith(separator)) {
            result = result.substring(0, result.length() - separator.length());
        }

        return result;
    }
}
