package com.saucedemo.utils;

import com.google.gson.Gson;
import com.saucedemo.dto.userbuilderjson.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
    public Users getFromJson(String fileName) {
        return new Gson().fromJson(new PageHandler().getReader(fileName), Users.class);
    }


}
