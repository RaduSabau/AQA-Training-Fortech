package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class SauceHomePage extends BasePage {

    protected WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@data-test=\"error\"]")
    private WebElement errorMessage;

    public SauceHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWith(String username, String password) {
        sendText(usernameField, username);
        sendText(passwordField, password);
        jsClick(loginButton);
        log.info("Logged in with {} | {}. {}", username,password, getErrorMessage());
    }

    public String getErrorMessage() {
        if (driver.findElements(By.xpath("//*[@data-test=\"error\"]")).size() > 0) {
            return "Error: " + readText(errorMessage);
        }
        return "";
    }
}
