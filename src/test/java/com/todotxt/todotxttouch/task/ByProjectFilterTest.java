package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ByProjectFilterTest {

    @Test
    public void testByProjectFilter1() {
        var projects = new ArrayList<String>();
        var byProjectFilter = new ByProjectFilter(projects);
        assertThat(byProjectFilter.getProjects().size()).isZero();
    }

    @Test
    public void testByProjectFilter2() {
        var projects = new ArrayList<String>();
        projects.add("test");
        var byProjectFilter = new ByProjectFilter(projects);
        assertThat(byProjectFilter.getProjects().size()).isNotZero();
    }

    @Test
    public void testApply1() {
        var input = new Task();
        var projects = new ArrayList<String>();
        var byProjectFilter = new ByProjectFilter(projects);
        assertTrue(byProjectFilter.apply(input));
    }

    @Test
    public void testApply3() {
        var input = mock(Task.class);
        var projects = new ArrayList<String>();
        projects.add("-");
        var byProjectFilter = new ByProjectFilter(projects);
        assertTrue(byProjectFilter.apply(input));
    }

    @Test
    public void testApply4() {
        var input = mock(Task.class);
        var projects = new ArrayList<String>();
        projects.add("test");
        var byProjectFilter = new ByProjectFilter(projects);
        assertFalse(byProjectFilter.apply(input));
    }

}
