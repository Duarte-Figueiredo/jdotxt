package com.todotxt.todotxttouch.task;

import com.todotxt.todotxttouch.util.TaskIo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class JdotxtTaskBagImplTest {

    LocalTaskRepository localRepository = new LocalFileTaskRepository();
    JdotxtTaskBagImpl jdotxtTaskBagImpl = new JdotxtTaskBagImpl(localRepository);

    @Test
    public void testStore1() {
        ArrayList<Task> tasks = new ArrayList<>();
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getTasks().size()).isZero();
    }

    @Test
    public void testArchive1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        jdotxtTaskBagImpl.archive();
        assertThat(jdotxtTaskBagImpl.getTasks().size()).isZero();
    }

    @Test
    public void testArchive2() {
        jdotxtTaskBagImpl.archive();
        assertThatException();
    }

    @Test
    public void testUnarchive() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        jdotxtTaskBagImpl.archive();
        jdotxtTaskBagImpl.unarchive(task);
        assertThat(jdotxtTaskBagImpl.getTasks().size()).isNotZero();
    }

    @Test
    public void testReload() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        jdotxtTaskBagImpl.reload();
        assertThat(jdotxtTaskBagImpl.getTasks().size()).isZero();
    }

    @Test
    public void testClear() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        jdotxtTaskBagImpl.clear();
        assertThat(jdotxtTaskBagImpl.getTasks().size()).isZero();
    }

    @Test
    public void testSize() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        jdotxtTaskBagImpl.size();
        assertThat(jdotxtTaskBagImpl.size()).isZero();
    }

    @Test
    public void testAddAsTask() {
        assertThrows(TaskPersistException.class, () -> jdotxtTaskBagImpl.addAsTask("new test"));
    }

    @Test
    public void testUpdate1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThrows(TaskPersistException.class, () -> jdotxtTaskBagImpl.update(task));
    }

    @Test
    public void testDelete1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThrows(TaskPersistException.class, () -> jdotxtTaskBagImpl.delete(task));
    }

    @Test
    public void testRemoteAPI() {
        jdotxtTaskBagImpl.pushToRemote(false);
        jdotxtTaskBagImpl.pushToRemote(false, false);
        jdotxtTaskBagImpl.pullFromRemote();
        jdotxtTaskBagImpl.pullFromRemote(false);
    }

    @Test
    public void testGetPriorities() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getPriorities().size()).isZero();
    }

    @Test
    public void testGetContexts1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = true;
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getContexts(includeNone).size()).isNotZero();
    }

    @Test
    public void testGetContexts2() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = false;
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getContexts(includeNone).size()).isZero();
    }

    @Test
    public void testGetProjects1() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = true;
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getProjects(includeNone).size()).isNotZero();
    }

    @Test
    public void testGetProjects2() {
        var task = mock(Task.class);
        ArrayList<Task> tasks = new ArrayList<>();
        var includeNone = false;
        tasks.add(task);
        jdotxtTaskBagImpl.store(tasks);
        assertThat(jdotxtTaskBagImpl.getProjects(includeNone).size()).isZero();
    }

    @Test
    public void testHasChanged() {
        assertFalse(jdotxtTaskBagImpl.hasChanged());
    }
}
