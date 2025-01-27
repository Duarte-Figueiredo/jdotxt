package com.todotxt.todotxttouch.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PathTest {

    @Test
    public void nullPathReturnsCorrectEmptyString() {
        var actual = Path.fileName(null);

        assertThat(actual).isEmpty();
    }

    @Test
    public void emptyPathReturnsEmptyFileName() {
        var path = "";

        var actual = Path.fileName(path);

        assertThat(actual).isEmpty();
    }

    @Test
    public void filenameReturnsFilename() {
        var path = "somefilename";

        var actual = Path.fileName(path);

        assertThat(actual).isEqualTo(path);
    }

    @Test
    public void validPathReturnsCorrectFilename() {
        var path = "/some/path/somefilename";
        var expected = "somefilename";

        var actual = Path.fileName(path);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void filename1() {
        var path = "/some/path/somefilename/";
        var expected = "somefilename";
        var pathInstance = new Path();

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

    @Test
    public void parentPath1() {
        String s = "TestingPath/NewPath/";
        String result = Path.parentPath(s);
        String expected = "TestingPath/";

        assertEquals(result, expected);
    }

    @Test
    public void filePath1() {
        String s = "TestingPath/NewPath/";
        String expected = "NewPath";
        String result = Path.fileName(s);

        assertEquals(result, expected);
    }

    @Test
    public void filePath3() {
        String s = "TestingPath/NewPath";
        String expected = "NewPath";
        String result = Path.fileName(s);

        assertEquals(result, expected);
    }

    @Test
    public void filePath4() {
        String s = "";
        String expected = "";
        String result = Path.fileName(s);

        assertEquals(result, expected);
    }


}