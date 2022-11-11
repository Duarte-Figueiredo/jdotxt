package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ByPriorityFilterTest {

    @Test
    public void testByPriorityFilter1() {
        var contexts = new ArrayList<Priority>();
        var byPriorityFilter = new ByPriorityFilter(contexts);
        assertThat(byPriorityFilter.getPriorities().size()).isZero();
    }

    @Test
    public void testByPriorityFilter2() {
        var priority = Priority.A;
        var contexts = new ArrayList<Priority>();
        contexts.add(priority);
        var byPriorityFilter = new ByPriorityFilter(contexts);
        assertThat(byPriorityFilter.getPriorities().size()).isNotZero();
    }

    @Test
    public void testApply1() {
        var input = new Task();
        var contexts = new ArrayList<Priority>();
        var byPriorityFilter = new ByPriorityFilter(contexts);
        assertTrue(byPriorityFilter.apply(input));
    }

    @Test
    public void testApply2() {
        var input = mock(Task.class);
        var priority = Priority.A;
        var contexts = new ArrayList<Priority>();
        contexts.add(priority);
        var byPriorityFilter = new ByPriorityFilter(contexts);
        assertFalse(byPriorityFilter.apply(input));
    }

    @Test
    public void testApply3() {
        var input = new Task();
        var priority = Priority.A;
        input.setPriority(priority);
        var contexts = new ArrayList<Priority>();
        contexts.add(priority);
        var byPriorityFilter = new ByPriorityFilter(contexts);
        assertTrue(byPriorityFilter.apply(input));
    }

}
