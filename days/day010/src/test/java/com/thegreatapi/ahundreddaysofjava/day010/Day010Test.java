package com.thegreatapi.ahundreddaysofjava.day010;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class Day010Test {

    @Test
    void fileDoesNotExist() {
        FileSystem fileSystem = Jimfs.newFileSystem(Configuration.unix());
        Path directory = fileSystem.getPath("/directory");
        Path file = directory.resolve(fileSystem.getPath("myfile.txt"));

        assertThatCode(() -> Files.write(file, "thegreatapi.com".getBytes(), StandardOpenOption.WRITE))
                .isInstanceOf(NoSuchFileException.class);
    }

    @Test
    void fileExists() throws IOException {
        FileSystem fileSystem = Jimfs.newFileSystem(Configuration.unix());
        Path directory = fileSystem.getPath("/directory");
        Path file = directory.resolve(fileSystem.getPath("myfile.txt"));

        Files.createDirectory(directory);
        Files.createFile(file);

        assertThatCode(() -> Files.write(file, "thegreatapi.com".getBytes(), StandardOpenOption.WRITE))
                .doesNotThrowAnyException();

        assertThat(Files.readString(file))
                .isEqualTo("thegreatapi.com");
    }
}