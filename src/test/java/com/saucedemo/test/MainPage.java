package com.saucedemo.test;

import com.demoqa.frontend.utils.BrowserReader;
import com.saucedemo.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class MainPage {
    protected WebDriver driver;
    private BrowserReader browserReader;

    @BeforeMethod
    public void setup() {
        browserReader = new BrowserReader("chrome");
        driver = browserReader.getDriver();
        driver.get(Constants.MAIN_SAUCEDEMO_URL);
    }

    @AfterMethod
    public void close() {
        if (browserReader != null) {
            browserReader.quit();
        }
    }
}
