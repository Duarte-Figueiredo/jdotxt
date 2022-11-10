package com.todotxt.todotxttouch.task.sorter;

import com.todotxt.todotxttouch.task.Task;

import static com.todotxt.todotxttouch.task.sorter.Sorters.*;

public class PredefinedSorters {
    public static final Sorter<Task> DEFAULT = PRIORITY.ascending().then(ID.ascending());
}
