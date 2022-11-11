package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TextSplitterTest {

    @Test
    public void textSplitter1() {
        var actual = TextSplitter.getInstance();

        assertThat(actual).isNotNull();
    }

    @Test
    public void split1() {
        var textSplitter = TextSplitter.getInstance();


        var actual = textSplitter.split(null);

        assertThat(actual).isNotNull();
    }

    @Test
    public void split2() {
        var textSplitter = TextSplitter.getInstance();
        var inputText = "inputText";

        var actual = textSplitter.split(inputText);

        assertThat(actual).isNotNull();
    }

    @Test
    public void split3() {
        var textSplitter = TextSplitter.getInstance();
        var inputText = "X inputText";

        var actual = textSplitter.split(inputText);

        assertThat(actual).isNotNull();
    }

    @Test
    public void split4() {
        var textSplitter = TextSplitter.getInstance();
        var inputText = "2000-01-01 2000-01-01 X aasd";

        var actual = textSplitter.split(inputText);

        assertThat(actual).isNotNull();
    }

    @Test
    public void split5() {
        var textSplitter = TextSplitter.getInstance();
        var inputText = "X 2000-01-01 2000-01-01 aasd";

        var actual = textSplitter.split(inputText);

        assertThat(actual).isNotNull();
    }

    @Test
    public void split6() {
        var textSplitter = TextSplitter.getInstance();
        var inputText = "X 2000-01-01 aasd";

        var actual = textSplitter.split(inputText);

        assertThat(actual).isNotNull();
    }
}