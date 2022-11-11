package com.todotxt.todotxttouch.task;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.*;

import static com.todotxt.todotxttouch.task.LocalFileTaskRepository.*;
import static java.lang.Math.random;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class LocalFileTaskTest {

    private LocalFileTaskRepository localFileTaskRepository = new LocalFileTaskRepository();

    @Test
    public void testInitFiles1() {
        TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo" + random() + ".txt");
        localFileTaskRepository.initFiles();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testInitFiles2() {
        localFileTaskRepository.initFiles();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testInit1() {
        TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo" + random() + ".txt");
        localFileTaskRepository.init();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testInit2() {
        localFileTaskRepository.init();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testPurge() {
        localFileTaskRepository.purge();
        boolean expected = false;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testLoad1() {
        TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo" + random() + ".txt");
        localFileTaskRepository.load();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testStore() {
        ArrayList<Task> tasks = new ArrayList<>();
        localFileTaskRepository.store(tasks);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testArchive1() {
        ArrayList<Task> tasks = new ArrayList<>();
        localFileTaskRepository.archive(tasks);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testArchive2() {
        ArrayList<Task> tasks = new ArrayList<>();
        var task1 = mock(Task.class);
        tasks.add(task1);
        var task2 = mock(Task.class);
        tasks.add(task2);
        localFileTaskRepository.archive(tasks);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testArchive3() {
        ArrayList<Task> tasks = new ArrayList<>();
        var task1 = mock(Task.class);
        task1.markComplete(new Date());
        tasks.add(task1);
        var task2 = mock(Task.class);
        task2.markComplete(new Date());
        tasks.add(task2);
        localFileTaskRepository.archive(tasks);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testLoadDoneTasks() {
        DONE_TXT_FILE = new File(DEFAULTDIR + File.separator + "done" + random() + ".txt");
        localFileTaskRepository.loadDoneTasks();
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testStoreDoneTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        var task = mock(Task.class);
        tasks.add(task);
        localFileTaskRepository.storeDoneTasks(tasks);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testTodoFileModifiedSince1() {
        localFileTaskRepository.todoFileModifiedSince(new Date());
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testTodoFileModifiedSince2() {
        localFileTaskRepository.todoFileModifiedSince(null);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testDoneFileModifiedSince1() {
        localFileTaskRepository.doneFileModifiedSince(new Date());
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }

    @Test
    public void testDoneFileModifiedSince2() {
        localFileTaskRepository.doneFileModifiedSince(null);
        boolean expected = true;
        assertEquals(expected, TODO_TXT_FILE.exists());
    }
}
