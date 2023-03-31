package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.elements.webTables.WebTablesPage;

import static constants.Constants.MAIN_URL;

public class BrowserSetup {
    protected WebDriver driver;
    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
//                .addArguments("--window-size=1920, 1080")
//                .addArguments("--disable-gpu")
//                .addArguments("--headless")
                .addArguments("disable-infobars")
                .addArguments("--start-maximized")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--disable-extensions")
                .addArguments("--no-sandbox");
    }
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(getChromeOptions());
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        WebpageHandler webpageHandler = new WebpageHandler(driver);
    }
    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
