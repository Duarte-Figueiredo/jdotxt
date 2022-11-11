package com.todotxt.todotxttouch.task;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TaskPersistExceptionTest {

    @Test
    public void taskPersistException1() {
        var taskPersistException = new TaskPersistException("some exception");

        assertThat(taskPersistException).isNotNull();
    }

    @Test
    public void taskPersistException2() {
        var throwable = mock(Throwable.class);
        var taskPersistException = new TaskPersistException("some exception", throwable);

        assertThat(taskPersistException).isNotNull();
    }
}