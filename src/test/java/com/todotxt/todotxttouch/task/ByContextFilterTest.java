package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ByContextFilterTest {


    @Test
    public void testByContextFilter1() {
        var contexts = new ArrayList<String>();
        var byContextFilter = new ByContextFilter(contexts);
        assertThat(byContextFilter.getContexts().size()).isZero();
    }

    @Test
    public void testByContextFilter2() {
        var contexts = new ArrayList<String>();
        contexts.add("Test");
        var byContextFilter = new ByContextFilter(contexts);
        assertThat(byContextFilter.getContexts().size()).isNotZero();
    }

    @Test
    public void testApply1() {
        var contexts = new ArrayList<String>();
        var input = new Task();
        var byContextFilter = new ByContextFilter(contexts);
        assertTrue(byContextFilter.apply(input));
    }

    @Test
    public void testApply3() {
        var contexts = new ArrayList<String>();
        var input = new Task();
        contexts.add("-");
        var byContextFilter = new ByContextFilter(contexts);
        assertTrue(byContextFilter.apply(input));
    }

    @Test
    public void testApply4() {
        var contexts = new ArrayList<String>();
        var input = new Task();
        contexts.add("test");
        var byContextFilter = new ByContextFilter(contexts);
        assertFalse(byContextFilter.apply(input));
    }
}
