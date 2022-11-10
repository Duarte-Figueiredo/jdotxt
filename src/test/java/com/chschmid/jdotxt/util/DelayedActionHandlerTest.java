package com.chschmid.jdotxt.util;

import org.junit.Test;

import java.awt.event.ActionListener;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DelayedActionHandlerTest {

    @Test
    public void test1() {
        var delayMills = 0;
        var actionListener = mock(ActionListener.class);

        var delayedActionHandler = new DelayedActionHandler(delayMills, actionListener);

        delayedActionHandler.triggerAction();

        verify(actionListener).actionPerformed(null);
    }
}