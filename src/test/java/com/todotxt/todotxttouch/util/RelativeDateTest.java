package com.todotxt.todotxttouch.util;


import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RelativeDateTest {

    private static final long SECOND = 1000; //milliseconds
    private static final long HOUR = 3600 * SECOND;
    private static final long DAY = 24 * HOUR;
    private static final long YEAR = 365 * DAY;
    private final Calendar today = new GregorianCalendar();

    public RelativeDateTest() {
        today.set(GregorianCalendar.HOUR_OF_DAY, 0);
        today.set(GregorianCalendar.MINUTE, 0);
        today.set(GregorianCalendar.SECOND, 0);
        today.set(GregorianCalendar.MILLISECOND, 0);
    }

    @Test
    public void relativeDate() {
        var relativeDate = new RelativeDate();

        assertThat(relativeDate).isNotNull();
    }

    @Test
    public void getRelativeDate1() {
        var calendar = mock(Calendar.class);

        var actual = RelativeDate.getRelativeDate(calendar);

        assertThat(actual).isNotNull();
    }

    @Test
    public void getRelativeDate2() {
        var calendar = mock(Calendar.class);

        when(calendar.getTimeInMillis()).thenReturn(today.getTimeInMillis() - 1);

        assertThrows(NullPointerException.class,
                     () -> RelativeDate.getRelativeDate(calendar));
    }

    @Test
    public void getRelativeDate3() {
        var calendar = mock(Calendar.class);

        when(calendar.getTimeInMillis()).thenReturn(today.getTimeInMillis() - DAY);

        assertThrows(NullPointerException.class,
                     () -> RelativeDate.getRelativeDate(calendar));
    }

    @Test
    public void getRelativeDate4() {
        var calendar = mock(Calendar.class);

        when(calendar.getTimeInMillis()).thenReturn(today.getTimeInMillis() - 2 * DAY);

        assertThrows(NullPointerException.class,
                     () -> RelativeDate.getRelativeDate(calendar));
    }

    @Test
    public void getRelativeDate5() {
        var calendar = mock(Calendar.class);

        when(calendar.getTimeInMillis()).thenReturn(today.getTimeInMillis() - 30 * DAY);

        assertThrows(NullPointerException.class,
                     () -> RelativeDate.getRelativeDate(calendar));
    }

    @Test
    public void getRelativeDate6() {
        var calendar = mock(Calendar.class);

        when(calendar.getTimeInMillis()).thenReturn(today.getTimeInMillis() - 60 * DAY);

        assertThrows(NullPointerException.class,
                     () -> RelativeDate.getRelativeDate(calendar));
    }

    @Test
    public void getRelativeDate7() {
        var date = mock(Date.class);

        var actual = RelativeDate.getRelativeDate(date);

        assertThat(actual).isNotNull();
    }
}