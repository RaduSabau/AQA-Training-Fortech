package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserReader;

import static constants.Constants.MAIN_URL;

public class MainPage {
    protected WebDriver driver;
    private BrowserReader browserReader;

    @BeforeClass
    public void setup() {
        browserReader = new BrowserReader("chrome");
        driver = browserReader.getDriver();
        driver.get(MAIN_URL);
    }

    @AfterClass
    public void close() {
        if (browserReader != null) {
            browserReader.quit();
        }
    }
}
