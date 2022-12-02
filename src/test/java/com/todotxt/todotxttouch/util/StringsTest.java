package com.todotxt.todotxttouch.util;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsTest {

    private static final String S = "string";
    private static final String STRING_TO_INSERT = "inserting new";

    @Test
    public void insertingAtZeroReturnsCorrectString() {
        var insertAt = 0;
        var expected = STRING_TO_INSERT + " " + S;

        var actual = Strings.insertPadded(S, insertAt, STRING_TO_INSERT);

        assertEquals(expected, actual);
    }

    @Test
    public void insertingAtMaxStringLengthReturnsCorrectString() {
        var insertAt = 6;
        var expected = S + " " + STRING_TO_INSERT + " ";

        var actual = Strings.insertPadded(S, insertAt, STRING_TO_INSERT);

        assertEquals(expected, actual);
    }

    @Test
    public void insertingEmptyStringOnStringReturnsCorrectString() {
        var insertAt = 0;

        var actual = Strings.insertPadded(S, insertAt, "");

        assertEquals(S, actual);
    }

    @Test
    public void insertingEmptyStringOnEmptyStringReturnsEmptyString() {
        var insertAt = 0;
        var expected = "";

        var actual = Strings.insertPadded("", insertAt, "");

        assertEquals(expected, actual);
    }

    @Test
    public void insertingStringOnEmptyStringReturnsCorrectStringWithWhiteSpaceSufix() {
        var insertAt = 0;
        var expected = STRING_TO_INSERT + " ";

        var actual = Strings.insertPadded("", insertAt, STRING_TO_INSERT);

        assertEquals(expected, actual);
    }

    @Test
    public void insertingAtNegativeThrowsOutOfBoundsException() {
        var insertAt = -1;

        var exception = assertThrows(IndexOutOfBoundsException.class,
                                     () -> Strings.insertPadded(S, insertAt, STRING_TO_INSERT));

        assertThat(exception).hasMessage("Invalid insertAt of [-1] for string [string]");
    }

    @Test
    public void insertingAtNumberLargerThatStringLengthThrowsOutOfBoundsException() {
        var insertAt = 7;

        var exception = assertThrows(IndexOutOfBoundsException.class,
                                     () -> Strings.insertPadded(S, insertAt, STRING_TO_INSERT));

        assertThat(exception).hasMessage("Range [0, 7) out of bounds for length 6");
    }

    @Test
    public void insertingStringOnNullThrowsNPE() {
        var insertAt = 0;

        assertThrows(NullPointerException.class,
                     () -> Strings.insertPadded(null, insertAt, STRING_TO_INSERT));
    }

    @Test
    public void insertingNullOnStringReturnsString() {
        var insertAt = 0;

        var actual = Strings.insertPadded(S, insertAt, null);

        assertThat(actual).isEqualTo(S);
    }

    @Test
    public void isEmptyOrNullReturnsTrueOnEmptyString() {
        String empty = "";

        boolean actual = Strings.isEmptyOrNull(empty);

        assertTrue(actual);
    }

    @Test
    public void isEmptyOrNullReturnsTrueOnBlankString() {
        boolean actual = Strings.isEmptyOrNull(null);

        assertTrue(actual);
    }

    @Test
    public void isEmptyOrNullReturnsFalseOnNonBlankString() {
        boolean actual = Strings.isEmptyOrNull("duarte");

        assertFalse(actual);
    }

    @Test
    public void strings1() {
        var strings = new Strings();

        assertThat(strings).isNotNull();
    }

    @Test
    public void insertPaddedIfNeeded1() {
        var s = "";
        var insertAt = 0;
        var stringToInsert = "";

        var actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

        assertThat(actual).isNotNull();
    }

    @Test
    public void insertPaddedIfNeeded2() {
        var s = "s";
        var insertAt = 1;
        var stringToInsert = "s";

        var actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

        assertThat(actual).isNotNull();
    }

    @Test
    public void insertPaddedIfNeeded3() {
        var s = "a";
        var insertAt = 2;
        var stringToInsert = "s";

        assertThrows(StringIndexOutOfBoundsException.class,
                     () -> Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert));
    }
}
