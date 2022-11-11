package com.todotxt.todotxttouch.task;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.todotxt.todotxttouch.task.LocalFileTaskRepository.TODO_TXT_FILE;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TaskBagImplTest {

    LocalTaskRepository localRepository = new LocalFileTaskRepository();
    private TaskBagImpl taskBag = new TaskBagImpl(localRepository);

    @Test
    public void testStore1() {
        ArrayList<Task> tasks = new ArrayList<>();
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getTasks().size()).isZero();
    }

    @Test
    public void testArchive1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        taskBag.archive();
        Assertions.assertThat(taskBag.getTasks().size()).isZero();
    }

    @Test
    public void testArchive2() {
        taskBag.archive();
        assertThatException();
    }

    @Test
    public void testUnarchive() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        taskBag.archive();
        taskBag.unarchive(task);
        Assertions.assertThat(taskBag.getTasks().size()).isNotZero();
    }

    @Test
    public void testReload() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        taskBag.reload();
        Assertions.assertThat(taskBag.getTasks().size()).isZero();
    }

    @Test
    public void testClear() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        taskBag.clear();
        Assertions.assertThat(taskBag.getTasks().size()).isZero();
    }


    @Test
    public void testSize() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        taskBag.size();
        Assertions.assertThat(taskBag.size()).isZero();
    }

    @Test
    public void testAddAsTask() {
        assertThrows(TaskPersistException.class, () -> taskBag.addAsTask("new test"));
    }

    @Test
    public void testUpdate1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        assertThrows(TaskPersistException.class, () -> taskBag.update(task));
    }

    @Test
    public void testDelete1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        assertThrows(TaskPersistException.class, () -> taskBag.delete(task));
    }

    @Test
    public void testRemoteAPI() {
        taskBag.pushToRemote(false);
        taskBag.pushToRemote(false, false);
        taskBag.pullFromRemote();
        taskBag.pullFromRemote(false);
    }

    @Test
    public void testGetPriorities() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getPriorities().size()).isZero();
    }

    @Test
    public void testGetContexts1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = true;
        tasks.add(task);
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getContexts(includeNone).size()).isNotZero();
    }

    @Test
    public void testGetContexts2() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = false;
        tasks.add(task);
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getContexts(includeNone).size()).isZero();
    }

    @Test
    public void testGetProjects1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = true;
        tasks.add(task);
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getProjects(includeNone).size()).isNotZero();
    }

    @Test
    public void testGetProjects2() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = false;
        tasks.add(task);
        taskBag.store(tasks);
        Assertions.assertThat(taskBag.getProjects(includeNone).size()).isZero();
    }

    @Test
    public void testHasChanged() {
        assertFalse(taskBag.hasChanged());
    }

}
