package com.todotxt.todotxttouch.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void nullPathReturnsEmpty() {
        String s = null;
        String result = Path.parentPath(s);

        assertThat(result).isEmpty();
    }

    @Test
    public void emptyPathReturnsEmpty() {
        String s = "";
        String result = Path.parentPath(s);

        assertThat(result).isEmpty();
    }

    @Test
    public void blankPathReturnsEmpty() {
        String s = " ";
        String result = Path.parentPath(s);

        assertThat(result).isEmpty();
    }

    @Test
    public void fullPathReturnsSplitPath() {
        String s = "TestingPath/NewPath";
        String result = Path.parentPath(s);
        String expected = "TestingPath/";

        assertEquals(result, expected);
    }
}