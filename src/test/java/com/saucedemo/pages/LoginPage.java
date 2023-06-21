package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Slf4j
public class LoginPage extends BasePage {
    private final By errorMessage = By.xpath("//*[@data-test=\"error\"]");
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWith(String username, String password) {
        sendText(usernameField, username);
        sendText(passwordField, password);
        jsClick(loginButton);
        log.info("Logged in with {} | {}. {}", username, password, getErrorMessage());
        if (!getErrorMessage().isEmpty()) {
            highlight(driver, findElement(errorMessage));
            takeScreenShot();
        }
    }

    public String getErrorMessage() {
        if (driver.findElements(errorMessage).size() > 0) {
            return readText(errorMessage);
        }
        return "";
    }


}
