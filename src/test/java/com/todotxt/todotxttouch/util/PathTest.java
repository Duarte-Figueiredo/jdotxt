package com.todotxt.todotxttouch.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathTest {

    @Test
    void nullPathReturnsCorrectEmptyString() {
        var actual = Path.fileName(null);

        assertThat(actual).isEmpty();
    }

    @Test
    void emptyPathReturnsEmptyFileName() {
        var path = "";

        var actual = Path.fileName(path);

        assertThat(actual).isEmpty();
    }

    @Test
    void filenameReturnsFilename() {
        var path = "somefilename";

        var actual = Path.fileName(path);

        assertThat(actual).isEqualTo(path);
    }

    @Test
    void validPathReturnsCorrectFilename() {
        var path = "/some/path/somefilename";
        var expected = "somefilename";

        var actual = Path.fileName(path);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void invalidPathReturnsFullPath() {
        var path = "\\some\\path\\somefilename";
        var expected = "somefilename";

        var actual = Path.fileName(path);

        assertThat(actual).isEqualTo(expected);
    }
}