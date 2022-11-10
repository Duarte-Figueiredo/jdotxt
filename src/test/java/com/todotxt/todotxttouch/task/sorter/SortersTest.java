package com.todotxt.todotxttouch.task.sorter;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortersTest {

    @Test
    public void testCompareLists1() {
        var list1 = List.of(1, 2);
        var list2 = List.of(3, 4);

        var actual = Sorters.compareLists(list1, list2);

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void testCompareLists2() {
        var list1 = List.of(1, 2);

        var actual = Sorters.compareLists(list1, list1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testCompareLists3() {
        var list1 = List.of(1, 2);
        var list2 = List.of(3);

        var actual = Sorters.compareLists(list1, list2);

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void testCompareLists4() {
        var list1 = List.of(1, 2);
        List<Integer> list2 = Collections.emptyList();

        var actual = Sorters.compareLists(list1, list2);

        assertThat(actual).isEqualTo(1);
    }
}