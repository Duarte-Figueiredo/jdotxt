package com.todotxt.todotxttouch.util;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    private static final Collection<String> SAMPLE_COLLECTION = List.of("a", "b", "c");

    @Test
    void emptyCollectionReturnsEmptyString() {
        var collection = Collections.emptyList();
        var delimiter = ",";

        var actual = Util.join(collection, delimiter);

        assertThat(actual).isEmpty();
    }

    @Test
    void nullCollectionReturnsEmptyString() {
        var delimiter = ",";

        var actual = Util.join(null, delimiter);

        assertThat(actual).isEmpty();
    }

    @Test
    void emptyDelimiterReturnsCorrectString() {
        var expected = "abc";

        var actual = Util.join(SAMPLE_COLLECTION, "");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void nullDelimiterReturnsCollectionWithNullLiteralStringDelimiter() {
        var expected = "anullbnullc";

        var actual = Util.join(SAMPLE_COLLECTION, null);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void semicolonDelimiterReturnsCorrectString() {
        var expected = "a,b,c";
        var delimiter = ",";

        var actual = Util.join(SAMPLE_COLLECTION, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void complexDelimiterReturnsCorrectString() {
        var expected = "a123b123c";
        var delimiter = "123";

        var actual = Util.join(SAMPLE_COLLECTION, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stringCollectionWithNullsThrowsNPE() {
        var collection = new java.util.ArrayList<>(List.of("a", "b"));
        collection.add(null);
        var delimiter = ",";
        var expected = "a,b,null";

        var actual = Util.join(collection, delimiter);

        assertThat(actual).isEqualTo(expected);
    }
}