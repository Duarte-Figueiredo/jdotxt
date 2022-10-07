package com.todotxt.todotxttouch.util;

import com.todotxt.todotxttouch.task.ThresholdDateParser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void testInsertPadded() {
        String s = "string";
        int insertAt = 0;
        String stringToInsert = "inserting new";
        String expected = "inserting new string";

        String result = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals(result, expected);
    }

    @Test
    public void testInsertPaddedIfNeeded() {
        String s = "string";
        int insertAt = 0;
        String stringToInsert = "inserting new";
        String expected = "inserting new string";

        String result = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

        assertEquals(result, expected);
    }

    @Test
    public void testIsEmptyOrNull() {
        String empty = "";

        boolean result = Strings.isEmptyOrNull(empty);

        assertTrue(result);
    }

    @Test
    public void testIsBlank() {
        String empty = "";

        boolean result = Strings.isBlank(empty);

        assertTrue(result);
    }
}
