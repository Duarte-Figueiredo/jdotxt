package com.todotxt.todotxttouch.task;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class MailAddressParserTest {

    private String task;

    private Set<String> expected;

    private Set<String> actual;

    @Before
    public void setUp() {
        task = null;
        expected = new HashSet<String>();
        actual = new HashSet<String>();
    }

    @Test
    public void correctParseTest(){
        task = "newmail@mail.com";

        expected.add("newmail@mail.com");
        actual.addAll(MailAddressParser.getInstance().parse(task));

        assertEquals(expected, actual);
    }

    @Test
    public void incorrectParseTest(){
        task = "newmail";

        expected.add("newmail@mail.com");
        actual.addAll(MailAddressParser.getInstance().parse(task));

        assertNotEquals(expected, actual);
    }
}
