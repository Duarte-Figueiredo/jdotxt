package com.todotxt.todotxttouch.util;

import com.todotxt.todotxttouch.TodoException;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilTest {

    private static final Collection<String> SAMPLE_COLLECTION = List.of("a", "b", "c");

    @Test
    public void emptyCollectionReturnsEmptyString() {
        var collection = Collections.emptyList();
        var delimiter = ",";

        var actual = Util.join(collection, delimiter);

        assertThat(actual).isEmpty();
    }

    @Test
    public void nullCollectionReturnsEmptyString() {
        var delimiter = ",";

        var actual = Util.join(null, delimiter);

        assertThat(actual).isEmpty();
    }

    @Test
    public void emptyDelimiterReturnsCorrectString() {
        var expected = "abc";

        var actual = Util.join(SAMPLE_COLLECTION, "");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void nullDelimiterReturnsCollectionWithNullLiteralStringDelimiter() {
        var expected = "anullbnullc";

        var actual = Util.join(SAMPLE_COLLECTION, null);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void semicolonDelimiterReturnsCorrectString() {
        var expected = "a,b,c";
        var delimiter = ",";

        var actual = Util.join(SAMPLE_COLLECTION, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void complexDelimiterReturnsCorrectString() {
        var expected = "a123b123c";
        var delimiter = "123";

        var actual = Util.join(SAMPLE_COLLECTION, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void stringCollectionWithNullsThrowsNPE() {
        var collection = new java.util.ArrayList<>(List.of("a", "b"));
        collection.add(null);
        var delimiter = ",";
        var expected = "a,b,null";

        var actual = Util.join(collection, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void renameFile1() {
        var origFile = mock(File.class);
        var newFile = mock(File.class);
        var overwrite = true;

        when(origFile.exists()).thenReturn(false);
        assertThrows(TodoException.class, () -> Util.renameFile(origFile, newFile, overwrite));
    }

    @Test
    public void renameFile2() {
        var origFile = mock(File.class);
        var overwrite = true;

        when(origFile.exists()).thenReturn(true);
        assertThrows(TodoException.class, () -> Util.renameFile(origFile, null, overwrite));
    }

    @Test
    public void renameFile3() {
        var origFile = mock(File.class);
        var newFile = mock(File.class);
        var newFileParent = mock(File.class);
        var overwrite = true;

        when(origFile.exists()).thenReturn(true);
        when(newFileParent.exists()).thenReturn(false);
        when(newFile.getParentFile()).thenReturn(newFileParent);
        when(newFileParent.getParentFile()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> Util.renameFile(origFile, newFile, overwrite));
    }

    @Test
    public void renameFile4() {
        var origFile = mock(File.class);
        var newFile = mock(File.class);
        var newFileParent = mock(File.class);
        var overwrite = true;

        when(origFile.exists()).thenReturn(true);
        when(newFileParent.exists()).thenReturn(true);
        when(newFileParent.mkdirs()).thenReturn(false);
        when(newFile.getParentFile()).thenReturn(newFileParent);
        assertThrows(TodoException.class, () -> Util.renameFile(origFile, newFile, overwrite));
    }
}