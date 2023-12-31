package com.demoqa.frontend.utils;

import com.demoqa.frontend.constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebpageHandler {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public WebpageHandler(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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

    public WebElement elementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickItemMenu(String itemMenu) {
        String itemMenuXpath = "//span[contains(text(),'" + itemMenu + "')]";
        clickElement(itemMenuXpath);
    }

    public void clickCategory(String category) {
        String categoryCardXpath = "//h5[contains(text(), '" + category + "')]";
        clickElement(categoryCardXpath);
    }

    private void clickElement(String categoryCardXpath) {
        WebElement menuCategoryElement = driver.findElement(By.xpath(categoryCardXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuCategoryElement);
        elementClickable(menuCategoryElement).click();
    }

    public void switchWindow(String urlIdentifier) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(urlIdentifier))
                break;
        }
    }

    public String getPageTitle() {
        WebElement pageTitle = driver.findElement(By.className(Constants.PAGE_TITLE_CLASS_NAME));
        findElement(pageTitle);
        return pageTitle.getText();
    }

    public void clickOnElementExecutor(WebElement element) {
        waitElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}


