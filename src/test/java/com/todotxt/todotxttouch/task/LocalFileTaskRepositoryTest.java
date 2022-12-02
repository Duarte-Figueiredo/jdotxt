package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;

public class LocalFileTaskRepositoryTest {

    private final LocalFileTaskRepository localFileTaskRepository = new LocalFileTaskRepository();

    @Test
    public void test1() {
        var actual = localFileTaskRepository.todoFileModifiedSince(null);
        assertThat(actual).isTrue();
    }

    @Test
    public void test2() {
        var date = new Date(1668199015000L);
        var actual = localFileTaskRepository.todoFileModifiedSince(date);
        assertThat(actual).isFalse();
    }
}