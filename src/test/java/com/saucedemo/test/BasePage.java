package com.saucedemo.test;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public abstract class BasePage {

    protected final WebDriverWait wait;
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private <T> void waitElement(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
        }
    }

    public <T> WebElement findElement(T elementAttr) {
        waitElement(elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr);
        } else {
            return ((WebElement) elementAttr);
        }
    }

    public <T> String readText(T elementAttr) {
        return findElement(elementAttr).getText();
    }

    public <T> void click(T elementAttr) {
        waitElement(elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    public void jsClick(WebElement element) {
        waitElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    private WebElement clearInputField(WebElement element) {
        waitElement(element);
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
        return element;
    }

    public <T> void sendText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            clearInputField(driver.findElement((By) elementAttr)).sendKeys(text);
        } else {
            clearInputField((WebElement) elementAttr).sendKeys(text);
        }
    }
}
