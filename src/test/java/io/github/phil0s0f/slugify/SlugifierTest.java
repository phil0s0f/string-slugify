package io.github.phil0s0f.slugify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlugifierTest {

    @Test
    void shouldCreateBasicSlug() {
        assertEquals("hello-world", Slugifier.slugify("Hello World"));
    }

    @Test
    void shouldRemoveExtraSpaces() {
        assertEquals("hello-world", Slugifier.slugify("  Hello    World  "));
    }

    @Test
    void shouldRemovePunctuation() {
        assertEquals("hello-world", Slugifier.slugify("Hello, World!"));
    }

    @Test
    void shouldNormalizeDiacritics() {
        assertEquals("creme-brulee", Slugifier.slugify("Crème brûlée"));
    }

    @Test
    void shouldUseCustomSeparator() {
        SlugifyOptions options = SlugifyOptions.builder()
                .separator("_")
                .build();

        assertEquals("hello_world", Slugifier.slugify("Hello World", options));
    }

    @Test
    void shouldPreserveCaseWhenConfigured() {
        SlugifyOptions options = SlugifyOptions.builder()
                .lowercase(false)
                .build();

        assertEquals("Hello-World", Slugifier.slugify("Hello World", options));
    }

    @Test
    void shouldRejectNullInput() {
        assertThrows(NullPointerException.class, () -> Slugifier.slugify(null));
    }

    @Test
    void shouldRejectEmptySeparator() {
        assertThrows(IllegalArgumentException.class, () ->
                SlugifyOptions.builder().separator("").build()
        );
    }
}
