package com.todotxt.todotxttouch.util;

import com.chschmid.jdotxt.gui.utils.SortUtils;
import com.todotxt.todotxttouch.task.sorter.Sorters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class SortUtilsTest {

    private final List<Map.Entry<Sorters, Boolean>> sortList;
    private final Object expected;

    public SortUtilsTest(List<Map.Entry<Sorters, Boolean>> sortList, Object expected) {
        this.sortList = sortList;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: writeSort({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Exception.class},
                {Collections.emptyList(), Exception.class},
                {Stream.ofNullable(null).collect(Collectors.toList()), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(null, null)), Exception.class},

                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(null, Boolean.FALSE)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(null, Boolean.TRUE)), Exception.class},

                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.ID, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.PRIORITY, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.TEXT, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.DATE, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.COMPLETION_DATE, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.PROJECTS, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.CONTEXTS, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.THRESHOLD_DATE, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.COMPLETION, null)), Exception.class},
                {List.of(new AbstractMap.SimpleEntry<Sorters, Boolean>(Sorters.DUE_DATE, null)), Exception.class},

                {List.of(new AbstractMap.SimpleEntry<>(Sorters.ID, Boolean.FALSE)), "ID:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.PRIORITY, Boolean.FALSE)), "PRIORITY:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.TEXT, Boolean.FALSE)), "TEXT:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.DATE, Boolean.FALSE)), "DATE:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.COMPLETION_DATE, Boolean.FALSE)), "COMPLETION_DATE:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.PROJECTS, Boolean.FALSE)), "PROJECTS:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.CONTEXTS, Boolean.FALSE)), "CONTEXTS:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.THRESHOLD_DATE, Boolean.FALSE)), "THRESHOLD_DATE:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.COMPLETION, Boolean.FALSE)), "COMPLETION:false"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.DUE_DATE, Boolean.FALSE)), "DUE_DATE:false"},

                {List.of(new AbstractMap.SimpleEntry<>(Sorters.ID, Boolean.TRUE)), "ID:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.PRIORITY, Boolean.TRUE)), "PRIORITY:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.TEXT, Boolean.TRUE)), "TEXT:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.DATE, Boolean.TRUE)), "DATE:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.COMPLETION_DATE, Boolean.TRUE)), "COMPLETION_DATE:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.PROJECTS, Boolean.TRUE)), "PROJECTS:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.CONTEXTS, Boolean.TRUE)), "CONTEXTS:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.THRESHOLD_DATE, Boolean.TRUE)), "THRESHOLD_DATE:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.COMPLETION, Boolean.TRUE)), "COMPLETION:true"},
                {List.of(new AbstractMap.SimpleEntry<>(Sorters.DUE_DATE, Boolean.TRUE)), "DUE_DATE:true"},

                {Arrays.stream(Sorters.values()).map(it -> new AbstractMap.SimpleEntry<>(it, Boolean.TRUE)).collect(Collectors.toList()),
                 "ID:true|PRIORITY:true|TEXT:true|DATE:true|COMPLETION_DATE:true|PROJECTS:true|CONTEXTS:true|THRESHOLD_DATE:true|COMPLETION:true|DUE_DATE:true"},
                {Arrays.stream(Sorters.values()).map(it -> new AbstractMap.SimpleEntry<>(it, Boolean.FALSE)).collect(Collectors.toList()),
                 "ID:false|PRIORITY:false|TEXT:false|DATE:false|COMPLETION_DATE:false|PROJECTS:false|CONTEXTS:false|THRESHOLD_DATE:false|COMPLETION:false|DUE_DATE:false"},
                });
    }

    @Test
    public void test() {
        if (expected.equals(Exception.class)) {
            assertThrows(Exception.class,
                         () -> SortUtils.writeSort(sortList));
        } else {
            var actual = SortUtils.writeSort(sortList);
            assertThat(actual).isEqualTo(expected);
        }
    }
}
