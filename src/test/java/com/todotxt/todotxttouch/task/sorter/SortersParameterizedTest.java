package com.todotxt.todotxttouch.task.sorter;

import com.todotxt.todotxttouch.task.Task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class SortersParameterizedTest {

    private final Sorters sorter;

    public SortersParameterizedTest(Sorters sorter) {
        this.sorter = sorter;
    }

    @Parameterized.Parameters(name = "{index}: sorter={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Sorters.ID},
                {Sorters.PRIORITY},
                {Sorters.TEXT},
                {Sorters.DATE},
                {Sorters.COMPLETION_DATE},
                {Sorters.PROJECTS},
                {Sorters.CONTEXTS},
                {Sorters.THRESHOLD_DATE},
                {Sorters.COMPLETION},
                {Sorters.DUE_DATE}
        });
    }

    @Test
    public void test() {
        var task1 = new Task();
        var task2 = new Task();
        var ascending = sorter.ascending();
        var descending = sorter.descending();

        var actualAscending = ascending.compare(task1, task2);
        var actualDescending = descending.compare(task1, task2);
        var name = sorter.getName();
        try {
            ascending.compare(null, null);
        } catch (Exception ignored) {
        }

        assertThat(actualAscending).isEqualTo(0);
        assertThat(actualDescending).isEqualTo(0);
        assertThat(name).isNotNull();
    }

    @Test
    public void testNull() {
        var ascending = sorter.ascending();
        var descending = sorter.descending();

        assertThrows(NullPointerException.class, () -> ascending.compare(null, null));
    }

    @Test
    public void testCompleted1() {
        var task1 = new Task();
        task1.markComplete(Date.from(Instant.EPOCH));
        var task2 = new Task();
        var ascending = sorter.ascending();
        var descending = sorter.descending();

        var actualAscending = ascending.compare(task1, task2);
        var actualDescending = descending.compare(task1, task2);

        assertThat(actualAscending).isNotNull();
        assertThat(actualDescending).isNotNull();
    }

    @Test
    public void testCompleted2() {
        var task1 = new Task();
        var task2 = new Task();
        task2.markComplete(Date.from(Instant.EPOCH));
        var ascending = sorter.ascending();
        var descending = sorter.descending();

        var actualAscending = ascending.compare(task1, task2);
        var actualDescending = descending.compare(task1, task2);

        assertThat(actualAscending).isNotNull();
        assertThat(actualDescending).isNotNull();
    }

    @Test
    public void testCompleted3() {
        var task1 = new Task();
        task1.markComplete(Date.from(Instant.EPOCH));
        var task2 = new Task();
        task2.markComplete(Date.from(Instant.EPOCH));
        var ascending = sorter.ascending();
        var descending = sorter.descending();

        var actualAscending = ascending.compare(task1, task2);
        var actualDescending = descending.compare(task1, task2);

        assertThat(actualAscending).isNotNull();
        assertThat(actualDescending).isNotNull();
    }
}