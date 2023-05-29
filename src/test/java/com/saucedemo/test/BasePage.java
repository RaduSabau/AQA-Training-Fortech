package com.saucedemo.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class BasePage {

    protected final WebDriverWait wait;
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow transparent; border: 3px solid blue;');", element);
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

    public List<String> getTextsFromPageToList(String element) {
        List<String> texts = new ArrayList<>();
        List<WebElement> textsElm = driver.findElements(By.className(element));
        for (WebElement textElm : textsElm) {
            texts.add(textElm.getText());
        }
        return texts;
    }

    public void takeScreenShot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/src/test/java/com/saucedemo/screenshots/" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
