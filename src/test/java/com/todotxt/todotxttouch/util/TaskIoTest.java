package com.todotxt.todotxttouch.util;


import com.todotxt.todotxttouch.task.Task;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TaskIoTest {


    @Test
    public void TaskIo1() {
        var actual = new TaskIo();

        assertThat(actual).isNotNull();
    }

    @Test
    public void loadTasksFromFile1() throws IOException {
        var file = mock(File.class);

        var actual = TaskIo.loadTasksFromFile(file);

        assertThat(actual).isEmpty();
    }

    @Test
    public void loadTasksFromFile2() {
        var file = new File(getClass().getClassLoader().getResource("testFile.txt").getFile());

        assertThrows(NullPointerException.class, () -> TaskIo.loadTasksFromFile(file));
    }

    @Test
    public void writeToFile1() {
        var tasks = List.of(new Task(), new Task());
        var file = new File(getClass().getClassLoader().getResource(".").getFile() + "randomFile.txt");

        TaskIo.writeToFile(tasks, file);
    }

}