import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSelenium {
    public static void main(String[] args) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(ops);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        final String url = "https://www.fortech.ro/careers/training-internship-programs/";
        final String loginButtonSelector = "contact";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.className(loginButtonSelector));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
}
