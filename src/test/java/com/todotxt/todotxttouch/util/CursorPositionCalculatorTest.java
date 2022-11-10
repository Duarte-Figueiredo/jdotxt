package com.todotxt.todotxttouch.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(Parameterized.class)
public class CursorPositionCalculatorTest {

    private static final String BLANK_STRING = "     ";
    private static final String EMPTY_STRING = "";
    private static final String SOME_VALUE = "SOME_VALUE";

    private final int priorCursorPosition;
    private final String priorValue;
    private final String newValue;
    private final Object expected;

    public CursorPositionCalculatorTest(int priorCursorPosition, String priorValue, String newValue, Object expected) {
        this.priorCursorPosition = priorCursorPosition;
        this.priorValue = priorValue;
        this.newValue = newValue;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: calculate({0},\"{1}\",\"{2}\") = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                {-1, null, null, Exception.class},
//                {-1, null, EMPTY_STRING, Exception.class},
//                {-1, null, BLANK_STRING, Exception.class},
//                {-1, null, SOME_VALUE, Exception.class},
//                {-1, EMPTY_STRING, null, Exception.class},
//                {-1, EMPTY_STRING, EMPTY_STRING, Exception.class},
//                {-1, EMPTY_STRING, BLANK_STRING, Exception.class},
//                {-1, EMPTY_STRING, SOME_VALUE, Exception.class},
//                {-1, BLANK_STRING, null, Exception.class},
//                {-1, BLANK_STRING, EMPTY_STRING, Exception.class},
//                {-1, BLANK_STRING, BLANK_STRING, Exception.class},
//                {-1, BLANK_STRING, SOME_VALUE, Exception.class},
//                {-1, SOME_VALUE, null, Exception.class},
//                {-1, SOME_VALUE, EMPTY_STRING, Exception.class},
//                {-1, SOME_VALUE, BLANK_STRING, Exception.class},
//                {-1, SOME_VALUE, SOME_VALUE, Exception.class},
                {0, null, null, 0},
                {0, null, EMPTY_STRING, 0},
                {0, null, BLANK_STRING, 5},
                {0, null, SOME_VALUE, 10},
                {0, EMPTY_STRING, null, 0},
                {0, EMPTY_STRING, EMPTY_STRING, 0},
                {0, EMPTY_STRING, BLANK_STRING, 5},
                {0, EMPTY_STRING, SOME_VALUE, 10},
                {0, BLANK_STRING, null, 0},
                {0, BLANK_STRING, EMPTY_STRING, 0},
                {0, BLANK_STRING, BLANK_STRING, 0},
                {0, BLANK_STRING, SOME_VALUE, 5},
                {0, SOME_VALUE, null, 0},
                {0, SOME_VALUE, EMPTY_STRING, 0},
                {0, SOME_VALUE, BLANK_STRING, 0},
                {0, SOME_VALUE, SOME_VALUE, 0},
                });
    }

    @Test
    public void test() {
        if (expected instanceof Integer) {
            var actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);
            assertThat(actual).isEqualTo(expected);
        } else {
            assertThrows(Exception.class,
                         () -> CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue));
        }
    }
}
