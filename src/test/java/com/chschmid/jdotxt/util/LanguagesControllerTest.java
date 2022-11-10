package com.chschmid.jdotxt.util;

import org.junit.Test;

import java.util.MissingResourceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LanguagesControllerTest {

    @Test
    public void languagesController1() {
        var languageController = new LanguagesController("English");
        assertThat(languageController).isNotNull();
    }


    @Test
    public void languagesController2() {
        var languageController = new LanguagesController("English");
        assertThrows(MissingResourceException.class,
                     () -> languageController.getWord("work"));
    }
}