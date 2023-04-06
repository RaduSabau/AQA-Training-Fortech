package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserReader {
    private WebDriver driver;
    public BrowserReader(String browserType) {
        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getOptions());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private ChromeOptions getOptions() {
        return new ChromeOptions()
                .addArguments("disable-infobars")
                .addArguments("--start-maximized")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--disable-extensions")
                .addArguments("--no-sandbox");
    }
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
