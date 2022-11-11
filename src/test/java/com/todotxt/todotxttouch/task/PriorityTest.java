package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PriorityTest {

    @Test
    public void testPriority() {
        var actual = Priority.A.getCode();
        var expected = Priority.A.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testInFileFormat() {
        var actual = Priority.A.inFileFormat();
        var expected = "(A)";
        assertEquals(expected, actual);
    }

    @Test
    public void testRange1() {
        var actual = Priority.range(Priority.A, Priority.B);
        var expected = 2;
        assertEquals(expected, actual.size());
    }

    @Test
    public void testRange2() {
        var actual = Priority.range(Priority.A, Priority.A);
        var expected = 1;
        assertEquals(expected, actual.size());
    }

    @Test
    public void testToPriority1() {
        var actual = Priority.toPriority("test");
        var expected = Priority.NONE;
        assertEquals(expected, actual);
    }

    @Test
    public void testToPriority2() {
        var actual = Priority.toPriority(null);
        var expected = Priority.NONE;
        assertEquals(expected, actual);
    }

}
