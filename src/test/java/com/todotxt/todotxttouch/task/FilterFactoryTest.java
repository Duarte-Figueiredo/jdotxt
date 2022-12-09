package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FilterFactoryTest {

    private FilterFactory filterFactory = new FilterFactory();
//    @Test
//    public void testGenerateAndFilters1() {
//        List<Priority> priorities = new ArrayList<>();
//        List<String> contexts = new ArrayList<>();
//        List<String> projects = new ArrayList<>();
//        String text = null;
//        boolean caseSensitive = true;
//        boolean showHidden = true;
//        boolean showThreshold = true;
//
//        var result = filterFactory.generateAndFilter(priorities, contexts,
//               projects, text, caseSensitive, showHidden, showThreshold);
//
//        assertEquals(0, result.getClass().getFields().length);
//    }

    @Test
    public void testGenerateAndFilters2() {
        List<Priority> priorities = new ArrayList<>();
        priorities.add(Priority.A);
        List<String> contexts = new ArrayList<>();
        contexts.add("test1");
        List<String> projects = new ArrayList<>();
        projects.add("test2");
        String text = "test3";
        boolean caseSensitive = false;
        boolean showHidden = false;
        boolean showThreshold = false;

        var result = filterFactory.generateAndFilter(priorities, contexts,
                projects, text, caseSensitive, showHidden, showThreshold);

        assertThat(result).isNotNull();
    }
}
