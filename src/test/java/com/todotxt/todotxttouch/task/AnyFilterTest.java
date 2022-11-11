package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AnyFilterTest {

    @Test
    public void testAddFilter1() {
        var andFilter = new AndFilter();
        var filter = mock(Filter.class);
        andFilter.addFilter(filter);
        assertThat(andFilter).isNotNull();
    }

    @Test
    public void testApply1() {
        var task = mock(Task.class);
        var andFilter = new AndFilter();
        var result = andFilter.apply(task);
        assertTrue(result);
    }

    @Test
    public void testApply2() {
        var filter = mock(Filter.class);
        var task = mock(Task.class);
        var andFilter = new AndFilter();
        andFilter.addFilter(filter);
        var result = andFilter.apply(task);
        assertFalse(result);
    }
}
