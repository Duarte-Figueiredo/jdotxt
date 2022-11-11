package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ByTextFilterTest {

    @Test
    public void testByTextFilter1() {
        String text = null;
        boolean caseSensitive = false;
        var expectedString = "";
        var expectedCase = false;
        var byProjectFilter = new ByTextFilter(text, caseSensitive);
        byProjectFilter.getText();
        assertEquals(expectedString, byProjectFilter.getText());
        assertEquals(expectedCase, byProjectFilter.isCaseSensitive());
    }

    @Test
    public void testByTextFilter2() {
        String text = "test";
        boolean caseSensitive = true;
        var expectedString = "test";
        var expectedCase = true;
        var byProjectFilter = new ByTextFilter(text, caseSensitive);
        byProjectFilter.getText();
        assertEquals(expectedString, byProjectFilter.getText());
        assertEquals(expectedCase, byProjectFilter.isCaseSensitive());
    }

    @Test
    public void testApply1() {
        var input = new Task();
        String text = null;
        boolean caseSensitive = false;
        var byProjectFilter = new ByTextFilter(text, caseSensitive);
        assertTrue(byProjectFilter.apply(input));
    }

    @Test
    public void testApply2() {
        var input = new Task();
        String text = "test";
        boolean caseSensitive = false;
        var byProjectFilter = new ByTextFilter(text, caseSensitive);
        assertFalse(byProjectFilter.apply(input));
    }

    @Test
    public void testApply3() {
        var input = new Task();
        String text = "test";
        boolean caseSensitive = true;
        var byProjectFilter = new ByTextFilter(text, caseSensitive);
        assertFalse(byProjectFilter.apply(input));
    }
}
