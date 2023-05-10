package com.saucedemo.utils;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PageHandler {

    public Reader getReader(String fileName) {
        try {
            return Files.newBufferedReader(getTestDataFile(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path getTestDataFile(String fileName) {
        try {
            return Path.of(ClassLoader.getSystemResource("testdata/" + fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
