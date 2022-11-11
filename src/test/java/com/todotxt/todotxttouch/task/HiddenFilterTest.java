package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class HiddenFilterTest {

    private HiddenFilter hiddenFilter = new HiddenFilter();

    @Test
    public void testApply1() {
        var task = new Task();
        assertTrue(hiddenFilter.apply(task));
    }

    //TODO: apply com result false
//    @Test
//    public void testApply2() {
//        var task = new Task();
//        assertTrue(hiddenFilter.apply(task));
//    }
}
