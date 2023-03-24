package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Utils {
    WebDriverWait wait;
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement elementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void findElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickItemMenu(String itemMenu) {
        String itemMenuXpath = "//span[contains(text(),'" + itemMenu + "')]";
        WebElement menuItem = driver.findElement(By.xpath(itemMenuXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuItem);
        elementClickable(menuItem).click();
    }
    public void clickCategory(String category) {
        String categoryCardXpath = "//h5[contains(text(), '" + category + "')]";
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

}


