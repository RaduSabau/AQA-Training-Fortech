package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserReader {
    private WebDriver driver;
    public BrowserReader(String browserType) {
        switch (browserType) {
            case "chrome" -> {
                driver = new ChromeDriver(getOptions());
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private ChromeOptions getOptions() {
        return new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--start-maximized")
                .addArguments("disable-infobars")
                .addArguments("--disable-dev-shm-usage");
    }

}
