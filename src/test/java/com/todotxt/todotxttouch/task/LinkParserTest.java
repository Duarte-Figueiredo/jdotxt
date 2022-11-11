package com.todotxt.todotxttouch.task;

import com.todotxt.todotxttouch.TodoException;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkParserTest {
    private String inputText;
    private Set<String> expected;
    private Set<URL> actual;

    @Before
    public void setUp() {
        inputText = null;
        expected = new HashSet<String>();
        actual = new HashSet<URL>();
    }

    @Test
    public void testApply1() {
        inputText = "https://www.test.pt";
        actual.addAll(LinkParser.getInstance().parse(inputText));
        assertThat(actual).isNotNull();
    }

    @Test
    public void testApply2() {
        inputText = null;
        expected = Collections.emptySet();
        actual.addAll(LinkParser.getInstance().parse(inputText));
        assertEquals(expected, actual);
    }
}
