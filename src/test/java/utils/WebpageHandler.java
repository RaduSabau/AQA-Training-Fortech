package utils;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebpageHandler {
    WebDriverWait wait;
    WebDriver driver;

    public WebpageHandler(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement elementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
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
}


