package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    WebDriverWait wait;

    public Utils(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
