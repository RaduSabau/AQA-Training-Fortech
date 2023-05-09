package com.saucedemo.pages;

import com.demoqa.frontend.utils.WebpageHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceHomePage {

    private final WebpageHandler webpageHandler;
    @FindBy(id = "user-name")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerButton;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    protected WebDriver driver;

    public SauceHomePage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void addStringInInputField(WebElement element, String value) {
        webpageHandler.findElement(element);
        element.sendKeys(value);
    }

    public void addClick(WebElement element) {
        webpageHandler.elementClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clearInputField(WebElement element) {
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
    }
}
