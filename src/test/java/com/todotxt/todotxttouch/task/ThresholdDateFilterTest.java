package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThresholdDateFilterTest {

    @Test
    public void apply1() {
        var thresholdDateFilter = new ThresholdDateFilter();
        var task = mock(Task.class);

        var actual = thresholdDateFilter.apply(task);

        assertThat(actual).isTrue();
    }

    @Test
    public void apply2() {
        var thresholdDateFilter = new ThresholdDateFilter();
        var task = mock(Task.class);
        var date = mock(Date.class);

        when(task.getThresholdDate()).thenReturn(date);
        when(date.getTime()).thenReturn(0L);
        var actual = thresholdDateFilter.apply(task);

        assertThat(actual).isTrue();
    }

}