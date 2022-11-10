package com.todotxt.todotxttouch.task.sorter;

import com.todotxt.todotxttouch.task.Task;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PredefinedSortersTest {

    @Test
    public void test() {
        var actual = PredefinedSorters.DEFAULT.compare(new Task(), new Task());

        assertThat(actual).isNotNull();
    }
}