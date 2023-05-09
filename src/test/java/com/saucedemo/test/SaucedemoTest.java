package com.saucedemo.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.saucedemo.pages.SauceHomePage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaucedemoTest extends MainPage {

    @Test
    public void saucedemoLoginAndLogoutTest() throws IOException {

        SauceHomePage sauceHomePage = new SauceHomePage(driver);
        String fileName = "src/test/resources/testdata/jsonData/usersJsonGeneratedFile.json";
        Path path = Paths.get(fileName);

        Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        JsonObject obj = new JsonParser().parse(reader).getAsJsonObject();
        JsonArray users = obj.get("users").getAsJsonArray();
        for (JsonElement user : users) {
            try{
            String username = user.getAsJsonObject().get("username").getAsString();
            String password = user.getAsJsonObject().get("password").getAsString();
            sauceHomePage.clearInputField(sauceHomePage.usernameField);
            sauceHomePage.clearInputField(sauceHomePage.passwordField);
            sauceHomePage.addStringInInputField(sauceHomePage.usernameField, username);
            sauceHomePage.addStringInInputField(sauceHomePage.passwordField, password);
            sauceHomePage.addClick(sauceHomePage.loginButton);
            sauceHomePage.addClick(sauceHomePage.burgerButton);
            sauceHomePage.addClick(sauceHomePage.logoutButton);
            }catch (Exception e){
                System.out.println("User is locked");
            }
        }
    }
}
