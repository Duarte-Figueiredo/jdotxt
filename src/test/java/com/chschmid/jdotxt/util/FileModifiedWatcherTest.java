package com.chschmid.jdotxt.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
//@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest(fullyQualifiedNames = "java.nio.file.FileSystems")
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

    @Test
    public void startProcessingEvents1() throws IOException, InterruptedException {
        mockStatic(FileSystems.class);

        var file = mock(File.class);
        var parentFile = mock(File.class);
        var parentFilePath = mock(Path.class);
        var watcher = mock(WatchService.class);
        var watchKey = mock(WatchKey.class);
        var watchEvent = mock(WatchEvent.class);
        var filesystem = mock(FileSystem.class);

        when(file.getParentFile()).thenReturn(parentFile);
        when(parentFile.toPath()).thenReturn(parentFilePath);
        when(FileSystems.getDefault()).thenReturn(filesystem);
        when(filesystem.newWatchService()).thenReturn(watcher);
        when(watchKey.pollEvents()).thenReturn(List.of(watchEvent));
        when(watchEvent.kind()).thenReturn(StandardWatchEventKinds.ENTRY_MODIFY);

        when(watcher.take()).thenReturn(watchKey);

        var fileModifiedWatcher = new FileModifiedWatcher();

        fileModifiedWatcher.startProcessingEvents();
    }


}