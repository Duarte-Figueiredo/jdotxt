package com.chschmid.jdotxt.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileModifiedWatcherTest {

    @Test
    public void fileModifiedWatcher1() throws IOException {
        var fileModifiedWatcher = new FileModifiedWatcher();

        assertThat(fileModifiedWatcher).isNotNull();
    }

    @Test
    public void registerFile1() throws IOException {
        var fileModifiedWatcher = new FileModifiedWatcher();
        var file = mock(File.class);
        var parentFile = mock(File.class);
        var parentFilePath = mock(Path.class);

        when(file.getParentFile()).thenReturn(parentFile);
        when(parentFile.toPath()).thenReturn(parentFilePath);

        var actual = fileModifiedWatcher.registerFile(file);

        assertThat(actual).isNull();
    }

    @Test
    public void unregisterFile1() throws IOException {
        var fileModifiedWatcher = new FileModifiedWatcher();

        var actual = fileModifiedWatcher.unRegisterFile();

        assertThat(actual).isNull();
    }

    @Test
    public void getFile1() throws IOException {
        var fileModifiedWatcher = new FileModifiedWatcher();

        var actual = fileModifiedWatcher.getFile();

        assertThat(actual).isNull();
    }

    @Test
    public void addAndRemoveFileModifiedListener1() throws IOException {
        var fileModifiedWatcher = new FileModifiedWatcher();
        var fileModifiedListener = mock(FileModifiedListener.class);

        fileModifiedWatcher.addFileModifiedListener(fileModifiedListener);
        fileModifiedWatcher.removeFileModifiedListener(fileModifiedListener);
    }


}