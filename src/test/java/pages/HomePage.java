package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final Utils utils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utils = new Utils(driver);
    }

    public void clickAlertFrameWindowsMenuButton(String category) {
        String categoryCardXpath = "//h5[contains(text(), '" + category + "')]";
        WebElement menuCategoryElement = driver.findElement(By.xpath(categoryCardXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuCategoryElement);
        utils.elementClickable(menuCategoryElement).click();
    }

}
